package com.SpringTest.Teste.controller.form;

import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.repositories.AdminRepository;
import com.SpringTest.Teste.repositories.ProductsRepository;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ProductsForm {
    @NotNull
    private long admin_id;
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

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
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

    public Products convert(AdminRepository adminRepository){
        Admins admin = adminRepository.findById(admin_id);

        return new Products(admin, product_name, status, description, size_area, type_culture);
    }
}
