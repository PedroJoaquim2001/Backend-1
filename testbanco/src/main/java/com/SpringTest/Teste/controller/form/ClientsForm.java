package com.SpringTest.Teste.controller.form;
import com.SpringTest.Teste.models.Clients;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ClientsForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String name;
    @NotNull
    private long phone_number;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String e_mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Clients converter(){
        return new Clients(name, phone_number, e_mail);
    }
}
