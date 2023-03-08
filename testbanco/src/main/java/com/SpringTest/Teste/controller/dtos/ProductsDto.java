package com.SpringTest.Teste.controller.dtos;


import com.SpringTest.Teste.models.Products;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsDto {
    private long id;
    private String product_name;
    private long admin_id;
    private String adminName;
    private boolean status;
    private String type_culture;
    private double size_area;
    private String description;
    private LocalDateTime date ;

    public ProductsDto(Products products) {
        this.id = products.getId();
        this.product_name = products.getProduct_name();
        this.admin_id = products.getAdmin_id().getId();
        this.adminName = products.getAdmin_id().getName();
        this.status = products.isStatus();
        this.description = products.getDescription();
        this.size_area = products.getSize_area();
        this.type_culture = products.getType_culture();
        this.date = products.getDate();
    }

    public long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public String getAdminName() {
        return adminName;
    }

    public boolean isStatus() {
        return status;
    }

    public String getType_culture() {
        return type_culture;
    }

    public double getSize_area() {
        return size_area;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static List<ProductsDto> convert(List<Products> product){
        return product.stream().map(ProductsDto::new).collect(Collectors.toList());
    }
}
