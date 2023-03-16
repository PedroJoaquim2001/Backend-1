package com.SpringTest.Teste.controller.dtos;


import com.SpringTest.Teste.models.CultureModel;
import com.SpringTest.Teste.models.ProductsModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductsDto {
    private UUID id;
    private String product_name;
    private UUID admin_id;
    private String adminName;
    private boolean status;
    private String culture_name;
    private double size_area;
    private String description;
    private LocalDateTime date ;

    public ProductsDto(ProductsModel productsModel) {
        this.id = productsModel.getId();
        this.product_name = productsModel.getProduct_name();
        this.admin_id = productsModel.getAdmin_id().getId();
        this.adminName = productsModel.getAdmin_id().getName();
        this.status = productsModel.isStatus();
        this.description = productsModel.getDescription();
        this.size_area = productsModel.getSize_area();
        this.culture_name = productsModel.getCulture_id().getCulture_name();
        this.date = productsModel.getDate();
    }

    public UUID getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public UUID getAdmin_id() {
        return admin_id;
    }

    public String getAdminName() {
        return adminName;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCulture_name() {return culture_name;}

    public double getSize_area() {
        return size_area;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {return date;}

    public static List<ProductsDto> convert(List<ProductsModel> product){
        return product.stream().map(ProductsDto::new).collect(Collectors.toList());
    }
}
