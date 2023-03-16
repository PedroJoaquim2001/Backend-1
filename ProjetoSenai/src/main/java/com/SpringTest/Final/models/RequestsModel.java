package com.SpringTest.Final.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Requests")
public class RequestsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id")
	private ClientsModel cliente_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
	private ProductsModel product_id;
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
	private AdminsModel admin_id;
	@Column(nullable = false)
	private LocalDateTime date = LocalDateTime.now();

	public RequestsModel(){

	}

	public RequestsModel(ClientsModel cliente_id, ProductsModel product_id, AdminsModel admin_id) {
		this.cliente_id = cliente_id;
		this.product_id = product_id;
		this.admin_id = admin_id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ClientsModel getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(ClientsModel cliente_id) {
		this.cliente_id = cliente_id;
	}

	public ProductsModel getProduct_id() {
		return product_id;
	}

	public void setProduct_id(ProductsModel product_id) {
		this.product_id = product_id;
	}

	public AdminsModel getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(AdminsModel admin_id) {
		this.admin_id = admin_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}

