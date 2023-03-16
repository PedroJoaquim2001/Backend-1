package com.SpringTest.Final.controller.dtos;

import com.SpringTest.Final.models.ClientsModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientsDto {
    private UUID id;
    private String name;
    private String phone_number;
    private String e_mail;

    public ClientsDto(ClientsModel client){
        this.id = client.getId();
        this.name = client.getName();
        this.phone_number = client.getPhone_number();
        this.e_mail = client.getE_mail();
    }

    public UUID getId() {return id;}

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public static List<ClientsDto> convert(List<ClientsModel> clients){
        return clients.stream().map(ClientsDto::new).collect(Collectors.toList());
    }
}
