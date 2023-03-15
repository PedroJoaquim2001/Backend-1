package com.SpringTest.Teste.controller.forms;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.models.CultureModel;
import com.SpringTest.Teste.models.ProductsModel;
import com.SpringTest.Teste.services.AdminsService;
import com.SpringTest.Teste.services.CultureService;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class ProductsForm {
    @NotNull
    private UUID admin_id;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String product_name;
    @NotNull
    private boolean status;
    @NotNull
    private UUID culture_id;
    @NotNull @Digits(integer = 12,fraction = 2)
    private double size_area;
    @NotNull @NotEmpty @Length(min = 1,max = 255)
    private String description;

    public UUID getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(UUID admin_id) {
        this.admin_id = admin_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getCulture_id() {return culture_id;}

    public void setCulture_id(UUID culture_id) {this.culture_id = culture_id;}

    public double getSize_area() {
        return size_area;
    }

    public void setSize_area(double size_area) {
        this.size_area = size_area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductsModel convert(AdminsService adminsService, CultureService cultureService){
        AdminsModel admin = adminsService.findById(admin_id).get();
        CultureModel culture = cultureService.findById(culture_id).get();

        return new ProductsModel(admin, product_name, status, culture, size_area, description);
    }
}