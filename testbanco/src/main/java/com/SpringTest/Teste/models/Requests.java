package com.SpringTest.Teste.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
	private Clients cliente_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
	private Products product_id;
    @ManyToOne
    @JoinColumn(name = "admin_id")
	private Admins admin_id;
	private LocalDateTime date = LocalDateTime.now();

	public Requests(){

	}

	public Requests(Clients cliente_id, Products product_id, Admins admin_id) {
		this.cliente_id = cliente_id;
		this.product_id = product_id;
		this.admin_id = admin_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Clients getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Clients cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Products getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Products product_id) {
		this.product_id = product_id;
	}

	public Admins getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Admins admin_id) {
		this.admin_id = admin_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}

