package com.SpringTest.Teste.controller.dtos;

import com.SpringTest.Teste.models.Clients;

import java.util.List;
import java.util.stream.Collectors;

public class ClientsDto {
    private String name;
    private long phone_number;
    private String e_mail;

    public ClientsDto(Clients client){
        this.name = client.getName();
        this.phone_number = client.getPhone_number();
        this.e_mail = client.getE_mail();
    }

    public String getName() {
        return name;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public static List<ClientsDto> convert(List<Clients> clients){
        return clients.stream().map(ClientsDto::new).collect(Collectors.toList());
    }
}
