package com.SpringTest.Teste.controller.forms;
import com.SpringTest.Teste.models.Admins;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AdminsForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String name;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String login;
    @NotNull @NotEmpty @Length(min = 1,max = 12)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admins convert(){
        return new Admins(name, login, password);
    }
}
