package com.HoodieStore.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.HoodieStore.model.Product;
import com.HoodieStore.repository.ProductRepository;



@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductRepository pr;



	@Override
	public List<Product> getProduct() {
		return pr.findAll();
	}

	@Override
	public String deleteproduct(Long id) {
		pr.deleteById(id);
		return "Product has been successfully deleted.";
	}

	@Override
	public void updateStock(int quantity, Long id) {
		Optional<Product> product=pr.findById(id);
		if(product.isPresent()) {
			product.get().setStock(product.get().getStock()-quantity);
		}
		pr.save(product.get());
	}


	@Override
	public Product getProductById(Long id) {
		Optional<Product> product=pr.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
			return new Product();

	}

	
	@Override
	public String addproduct(
			String productTitle, 
			String productDescription,
			String productcategory, 
			int productStock,
			String productSize, 
			float productPrice,
			int productQuantity,
			MultipartFile file,
			List<MultipartFile> filelist) throws IOException  {
		
		Product newProduct =new Product();
		
		newProduct.setTitle(productTitle);
		newProduct.setDescription(productDescription);
		newProduct.setCategory(productcategory);
		newProduct.setPrice(productPrice);
		newProduct.setQuantity(productQuantity);
		newProduct.setSize(productSize);
		newProduct.setStock(productStock);
		newProduct.setMainimage(file.getBytes());
		
		List<byte[]> extraImageByte =new ArrayList<>();
		for (MultipartFile multipartFile : filelist) {
			extraImageByte.add(multipartFile.getBytes());
		}
		
		newProduct.setExtraimage(extraImageByte);
		
		pr.save(newProduct);
		
		return "Product Added Successfully.";
	}

	  @Override
	    public List<Product> getProductsByCategory(String category) {
	        return pr.findByCategory(category);
	    }


}
