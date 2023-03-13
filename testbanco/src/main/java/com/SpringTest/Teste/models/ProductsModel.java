package com.SpringTest.Teste.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
public class ProductsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminsModel admin_id;
	@Column(nullable = false, length = 50)
	private String product_name;
	@Column(nullable = false)
	private boolean status = true;
	@JoinColumn(name = "type_culture")
	private String type_culture;
	@Column(nullable = false)
	private double size_area;
	@Column(nullable = false)
	private LocalDateTime date = LocalDateTime.now();
	@Column(nullable = false, length = 255)
	private String description;

	public ProductsModel(){

	}

	public ProductsModel(AdminsModel admin_id, String product_name, boolean status, String type_culture, double size_area, String description) {
		this.admin_id = admin_id;
		this.product_name = product_name;
		this.status = status;
		this.type_culture = type_culture;
		this.size_area = size_area;
		this.description = description;
	}

	public AdminsModel getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(AdminsModel admin_id) {
		this.admin_id = admin_id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		this.type_culture = type_culture;
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
