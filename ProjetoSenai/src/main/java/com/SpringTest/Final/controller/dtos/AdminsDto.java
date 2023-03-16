package com.SpringTest.Final.controller.dtos;

import com.SpringTest.Final.models.AdminsModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AdminsDto {
    private UUID id;
    private String name;
    private String login;
    private String password;

    public AdminsDto(AdminsModel admin){
        this.id = admin.getId();
        this.name = admin.getName();
        this.login = admin.getLogin();
        this.password = admin.getPassword();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static List<AdminsDto> convert(List<AdminsModel> adminsModels){
        return adminsModels.stream().map(AdminsDto::new).collect(Collectors.toList());
    }
}
