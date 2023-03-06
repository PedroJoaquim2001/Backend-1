package com.SpringTest.Teste.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long phone_number;
	private String e_mail;

	public Clients(){
	}

	public Clients(String name, long phone_number, String e_mail){
		this.name = name;
		this.phone_number = phone_number;
		this.e_mail = e_mail;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public String getE_mail() {
		return e_mail;
	}
}
