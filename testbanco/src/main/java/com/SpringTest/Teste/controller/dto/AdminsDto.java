package com.SpringTest.Teste.controller.dto;

import com.SpringTest.Teste.models.Admins;

import java.util.List;
import java.util.stream.Collectors;

public class AdminsDto {
    private long id;
    private String name;
    private String login;
    private String password;

    public AdminsDto(Admins admin){
        this.id = admin.getId();
        this.name = admin.getName();
        this.login = admin.getLogin();
        this.password = admin.getPassword();
    }

    public long getId() {
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

    public static List<AdminsDto> convert(List<Admins> Admins){
        return Admins.stream().map(AdminsDto::new).collect(Collectors.toList());
    }
}
