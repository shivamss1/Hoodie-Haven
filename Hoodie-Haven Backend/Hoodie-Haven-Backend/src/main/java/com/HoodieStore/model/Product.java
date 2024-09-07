package com.HoodieStore.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long p_id;
	
	@Column(name = "Product-title")
	private String title;
	
	@Column(length = 1000)
	private String description;
	
	private float price;
	
	private int quantity;
	
	private String size;
	
	private int stock;
	
	private String category;
	
	@Column(name = "mainimage",columnDefinition = "LONGBLOB")
	private byte[] mainimage;
	
	@Column(columnDefinition = "LONGBLOB")
	@ElementCollection
	private List<byte[]> extraimage;
	
	
}
