package com.SpringTest.Teste.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "IMAGEDATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private byte[] imageData;

}
