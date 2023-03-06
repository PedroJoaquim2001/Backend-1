package com.SpringTest.Teste.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Admins {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String login;
	private String password;
	private boolean type_admin = false;

	public Admins(){
	}

	public Admins(String name, String login, String password){
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isType_admin() {
		return type_admin;
	}
}
