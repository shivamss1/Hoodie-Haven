package com.HoodieStore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.HoodieStore.model.Product;
import com.HoodieStore.service.ProductServiceImp;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImp ps;
	
	@PostMapping("/add-product")
	public Product addProduct( @RequestParam("productTitle") String productTitle,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("productPrice") float productPrice,
            @RequestParam("productQuantity") int productQuantity,
            @RequestParam("productSize") String productSize,
            @RequestParam("productStock") int productStock,
            @RequestParam("productcategory") String productcategory,
            @RequestPart("mainImage") MultipartFile file,
            @RequestPart("imageList") List<MultipartFile> filelist) throws IOException {
		return ps.addproduct(productTitle,productDescription,productcategory,productStock,productSize,productPrice,productQuantity,file,filelist);
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
