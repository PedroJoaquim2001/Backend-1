package com.SpringTest.Teste.controller.forms;

import com.SpringTest.Teste.models.AdminsModel;
import com.SpringTest.Teste.models.ProductsModel;
import com.SpringTest.Teste.services.AdminsService;
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
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String type_culture;
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

    public String getType_culture() {
        return type_culture;
    }

    public void setType_culture(String type_culture) {
        this.type_culture = type_culture;
    }

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

    public ProductsModel convert(AdminsService adminsService){
        AdminsModel admin = adminsService.findById(admin_id).get();

        return new ProductsModel(admin, product_name, status, description, size_area, type_culture);
    }
}
