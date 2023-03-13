package com.SpringTest.Teste.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "CLIENTS")
public class ClientsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 35)
	private String name;
	@Column(nullable = false, length = 20)
	private String phone_number;
	@Column(nullable = false, length = 50)
	private String e_mail;

	public ClientsModel(){
	}

	public ClientsModel(String name, String phone_number, String e_mail) {
		this.name = name;
		this.phone_number = phone_number;
		this.e_mail = e_mail;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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
}
