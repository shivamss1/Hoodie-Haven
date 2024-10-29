package com.HoodieStore.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.HoodieStore.model.Product;

public interface ProductService {


	public List<Product> getProduct();

	public String deleteproduct(Long id) ;

	public void updateStock(int quantity,Long id);

	public Product getProductById(Long id);

	public String addproduct(String productTitle, String productDescription, String productcategory, int productStock,
			String productSize, float productPrice, int productQuantity, MultipartFile file,
			List<MultipartFile> filelist) throws IOException;



    List<Product> getProductsByCategory(String category);

}
