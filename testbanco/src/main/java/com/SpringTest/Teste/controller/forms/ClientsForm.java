package com.SpringTest.Teste.controller.forms;
import com.SpringTest.Teste.models.ClientsModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ClientsForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String name;
    @NotNull
    private String phone_number;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String e_mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public ClientsModel convert(){
        return new ClientsModel(name, phone_number, e_mail);
    }
}
