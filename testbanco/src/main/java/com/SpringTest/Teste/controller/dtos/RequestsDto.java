package com.SpringTest.Teste.controller.dtos;

import com.SpringTest.Teste.models.RequestsModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RequestsDto {
    private UUID id;
    private UUID cliente_id;
    private String clientName;
    private UUID product_id;
    private String productName;
    private UUID admin_id;
    private String adminName;
    private LocalDateTime date ;

    public RequestsDto(RequestsModel requestsModel){
        this.id = requestsModel.getId();;
        this.cliente_id = requestsModel.getCliente_id().getId();
        this.clientName = requestsModel.getCliente_id().getName();
        this.product_id = requestsModel.getProduct_id().getId();
        this.productName = requestsModel.getProduct_id().getProduct_name();
        this.admin_id = requestsModel.getAdmin_id().getId();
        this.adminName = requestsModel.getAdmin_id().getName();
        this.date = requestsModel.getDate();
    }

    public UUID getId() {
        return id;
    }

    public UUID getCliente_id() {
        return cliente_id;
    }

    public String getClientName() {
        return clientName;
    }

    public UUID getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public UUID getAdmin_id() {
        return admin_id;
    }

    public String getAdminName() {
        return adminName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static List<RequestsDto> convert(List<RequestsModel> requestsModelList){
        return requestsModelList.stream().map(RequestsDto::new).collect(Collectors.toList());
    }
}
