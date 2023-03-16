package com.SpringTest.Final.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "CULTURE")
public class CultureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 35)
    private String culture_name;

    public CultureModel(){
    }

    public CultureModel(String culture_name) {
        this.culture_name = culture_name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCulture_name() {
        return culture_name;
    }

    public void setCulture_name(String culture_name) {
        this.culture_name = culture_name;
    }
}
