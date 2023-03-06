package com.SpringTest.Teste.models;

import jakarta.persistence.*;

@Entity
public class Photos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String photo_name;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product_id;

	public Photos(){
	}

	public long getId() {
		return id;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public Products getProduct_id() {
		return product_id;
	}
}
