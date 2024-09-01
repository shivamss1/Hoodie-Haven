package com.HoodieStore.service;

import java.util.List;

import com.HoodieStore.model.Product;

public interface ProductService {

	public Product addproduct(Product product);
	
	public List<Product> getProduct();
	
	public String deleteproduct(Long id) ;
	
	public void updateStock(int quantity,Long id);
}
