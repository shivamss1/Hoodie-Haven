package com.HoodieStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Form {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 long id;
	 String name;
	 
	 String email;
	 
	 String phoneno;
	 
	 String address;
	 
}
