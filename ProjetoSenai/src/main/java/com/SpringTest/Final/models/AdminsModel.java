package com.SpringTest.Final.models;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "ADMINS")
public class AdminsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 35)
	private String name;
	@Column(nullable = false, unique = true, length = 50)
	private String login;
	@Column(nullable = false, unique = true, length = 20)
	private String password;
	@Column(nullable = false )
	private boolean type_admin = false;

	public AdminsModel(){
	}

	public AdminsModel(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
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

	public boolean isType_admin() {
		return type_admin;
	}

	public void setType_admin(boolean type_admin) {
		this.type_admin = type_admin;
	}
}
