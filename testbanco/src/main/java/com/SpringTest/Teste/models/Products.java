package com.SpringTest.Teste.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admins admin_id;
	private String product_name;
	private boolean status;
	private String type_culture;
	private double size_area;
	private LocalDateTime date = LocalDateTime.now();
	private String description;

	public Products(){

	}
	public Products(Admins admin_id, String product_name, boolean status, String description, double size_area, String type_culture) {
		this.admin_id = admin_id;
		this.product_name = product_name;
		this.status = status;
		this.description = description;
		this.size_area = size_area;
		this.type_culture = type_culture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Admins getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Admins admin_id) {
		this.admin_id = admin_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getType_culture() {
		return type_culture;
	}

	public void setType_culture(String type_culture) {
		type_culture = type_culture;
	}

	public double getSize_area() {
		return size_area;
	}

	public void setSize_area(double size_area) {
		this.size_area = size_area;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
