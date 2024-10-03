package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Product;
import com.HoodieStore.service.ProductService;


@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private ProductService ps;

	@GetMapping("/id")
	public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
		Product product= ps.getProductById(id);
		if(product!=null) {
			return  ResponseEntity.ok(product);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); 
	}
	
	

	@GetMapping("/category")
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("category") String category){
		
		try {
			return  ResponseEntity.ok(ps.getProductsByCategory(category));	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		
	}
	
}
