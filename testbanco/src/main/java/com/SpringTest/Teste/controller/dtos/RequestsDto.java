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
    private Clients cliente_id;
    private Products product_id;
    private Admins admin_id;
    private LocalDateTime date ;

    public RequestsDto(Requests requests){
        this.id = requests.getId();;
        this.cliente_id = requests.getCliente_id();
        this.product_id = requests.getProduct_id();
        this.admin_id = requests.getAdmin_id();
        this.date = requests.getDate();
    }

    public long getId() {
        return id;
    }

    public long getCliente_id() {
        return cliente_id.getId();
    }

    public long getProduct_id() {
        return product_id.getId();
    }

    public long getAdmin_id() {
        return admin_id.getId();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static List<RequestsDto> convert(List<Requests> requestsList){
        return requestsList.stream().map(RequestsDto::new).collect(Collectors.toList());
    }
}
