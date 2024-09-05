package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Product;
import com.HoodieStore.service.ProductServiceImp;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImp ps;
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		return ps.addproduct(product);
	}
	
	@GetMapping("/products")
	public List<Product> getProduct(){
		return ps.getProduct();
	}
	
	@DeleteMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") Long id) {
		return ps.deleteproduct(id);
	}
	
	@PutMapping("/update-stock")
	public void updateStock(@RequestParam("quantity") int quantity,@RequestParam("id") Long id) {
		ps.updateStock(quantity,id);
	}
	
	@GetMapping("/product")
	public Product getProductById(@RequestParam("id") Long id) {
		return ps.getProductById(id);
	}
}
