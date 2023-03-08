package com.SpringTest.Teste.controller.dtos;

import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.models.Clients;
import com.SpringTest.Teste.models.Products;
import com.SpringTest.Teste.models.Requests;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RequestsDto {
    private long id;
    private long cliente_id;
    private String clientName;
    private long product_id;
    private String productName;
    private long admin_id;
    private String adminName;
    private LocalDateTime date ;

    public RequestsDto(Requests requests){
        this.id = requests.getId();;
        this.cliente_id = requests.getCliente_id().getId();
        this.clientName = requests.getCliente_id().getName();
        this.product_id = requests.getProduct_id().getId();
        this.productName = requests.getProduct_id().getProduct_name();
        this.admin_id = requests.getAdmin_id().getId();
        this.adminName = requests.getAdmin_id().getName();
        this.date = requests.getDate();
    }

    public long getId() {
        return id;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public String getClientName() {
        return clientName;
    }

    public long getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public String getAdminName() {
        return adminName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static List<RequestsDto> convert(List<Requests> requestsList){
        return requestsList.stream().map(RequestsDto::new).collect(Collectors.toList());
    }
}
