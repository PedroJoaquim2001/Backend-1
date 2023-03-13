package com.SpringTest.Teste.controller.forms;

import com.SpringTest.Teste.models.CultureModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CultureForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String culture_name;

    public String getCulture_name() {
        return culture_name;
    }

    public void setCulture_name(String culture_name) {
        this.culture_name = culture_name;
    }

    public CultureModel convert(){
        return new CultureModel(culture_name);
    }
}
