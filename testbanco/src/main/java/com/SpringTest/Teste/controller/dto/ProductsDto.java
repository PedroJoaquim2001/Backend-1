package com.SpringTest.Teste.controller.dto;


import com.SpringTest.Teste.models.Products;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsDto {

    private String product_name;
    private boolean status;
    private String type_culture;
    private double size_area;
    private String description;
    private long id;

    public ProductsDto(Products products) {
        this.id = products.getId();
        this.product_name = products.getProduct_name();
        this.status = products.isStatus();
        this.description = products.getDescription();
        this.size_area = products.getSize_area();
        this.type_culture = products.getType_culture();

    }

    public long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public boolean isStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }

    public double getSize_area() {
        return size_area;
    }
    public String getType_culture() {
        return type_culture;
    }




    public static List<ProductsDto> convert(List<Products> product){
        return product.stream().map(ProductsDto::new).collect(Collectors.toList());
    }
}
