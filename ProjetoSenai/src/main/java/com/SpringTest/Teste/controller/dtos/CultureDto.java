package com.SpringTest.Teste.controller.dtos;


import com.SpringTest.Teste.models.CultureModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CultureDto {
    private UUID id;
    private String culture_name;

    public CultureDto(CultureModel cultureModel) {
        this.id = cultureModel.getId();
        this.culture_name = cultureModel.getCulture_name();
    }

    public UUID getId() {
        return id;
    }

    public String getCulture_name() {
        return culture_name;
    }

    public static List<CultureDto> convert(List<CultureModel> cultureModels){
        return cultureModels.stream().map(CultureDto::new).collect(Collectors.toList());}
}
