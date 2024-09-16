package com.HoodieStore.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<String> addProduct( @RequestParam("productTitle") String productTitle,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("productPrice") float productPrice,
            @RequestParam("productQuantity") int productQuantity,
            @RequestParam("productSize") String productSize,
            @RequestParam("productStock") int productStock,
            @RequestParam("productcategory") String productcategory,
            @RequestPart("mainImage") MultipartFile file,
            @RequestPart("imageList") List<MultipartFile> filelist) throws IOException {
		try {
			return  new ResponseEntity(ps.addproduct(productTitle,productDescription,productcategory,productStock,productSize,productPrice,productQuantity,file,filelist),HttpStatus.CREATED);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return  new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> product=ps.getProduct();
		if(product!=null && !product.isEmpty()) {
		return new ResponseEntity(product,HttpStatus.OK);
		}	
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete-product")
	public ResponseEntity<String> deleteProduct(@RequestParam("id") Long id) {
		String msg= ps.deleteproduct(id);
		return new ResponseEntity(msg,HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update-stock")
	public ResponseEntity updateStock(@RequestParam("quantity") int quantity,@RequestParam("id") Long id) {
		ps.updateStock(quantity,id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
		Product product= ps.getProductById(id);
		if(product!=null) {
			return new ResponseEntity(product,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND); 
	}
	
	
	@GetMapping("/category")
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam("category") String category){
		
		try {
			return new ResponseEntity(ps.getProductsByCategory(category),HttpStatus.OK);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
	}

}