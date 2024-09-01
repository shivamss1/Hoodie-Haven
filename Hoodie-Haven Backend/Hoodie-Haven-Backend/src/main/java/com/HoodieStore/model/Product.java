package com.HoodieStore.model;

import jakarta.persistence.Column;
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
	
	private String description;
	
	private float price;
	
	private int quantity;
	
	private String size;
	
	private int stock;
	
	private String category;
	
}
