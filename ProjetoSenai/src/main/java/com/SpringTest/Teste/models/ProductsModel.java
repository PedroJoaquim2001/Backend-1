package com.SpringTest.Teste.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
	@ManyToOne
	@JoinColumn(name = "culture_id")
	private CultureModel culture_id;
	@Column(nullable = false)
	private double size_area;
	@Column(nullable = false)
	private LocalDateTime date = LocalDateTime.now();
	@Column(nullable = false, length = 255)
	private String description;
	@OneToMany
	@JoinColumn(name = "image_list")
	private List<ImageModel> image_list = new ArrayList<ImageModel>();

	public ProductsModel(){

	}

	public ProductsModel(AdminsModel admin_id, String product_name, boolean status, CultureModel culture_id, double size_area, String description) {
		this.admin_id = admin_id;
		this.product_name = product_name;
		this.status = status;
		this.culture_id = culture_id;
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

	public CultureModel getCulture_id() {return culture_id;}

	public void setCulture_id(CultureModel culture_id) {this.culture_id = culture_id;}

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

	public List<ImageModel> getImage_list() {
		return image_list;
	}

	public void setImage_list(List<ImageModel> image_list) {
		this.image_list = image_list;
	}

	public void addImage(ImageModel imageModel) {
		image_list.add(imageModel);
	}
}
