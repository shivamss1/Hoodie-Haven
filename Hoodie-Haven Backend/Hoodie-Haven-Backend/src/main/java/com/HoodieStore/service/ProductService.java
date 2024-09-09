package com.HoodieStore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.HoodieStore.model.Product;

public interface ProductService {

	
	public List<Product> getProduct();
	
	public String deleteproduct(Long id) ;
	
	public void updateStock(int quantity,Long id);
	
	public Product getProductById(Long id);

	Product addproduct(Product product);
	
    List<Product> getProductsByCategory(String category);
	 
}