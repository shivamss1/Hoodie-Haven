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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,nullable = false)
	private String username;
	
	@Column(nullable = false ,unique = true)
	private String mailid;
	
	@Column(nullable = false)
	private String mobileno;
	
	@Column(nullable = false)
	private String password;
	
}
