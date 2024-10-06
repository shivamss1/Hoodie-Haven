package com.HoodieStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.Product;
import com.HoodieStore.service.CartService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CartController {
	@Autowired
   private CartService cartService;
	
	@PostMapping("/addToCart")
	public String addtocart(long userId,long productId) {
		return cartService.addtocart(userId, productId);
	}
	
	@DeleteMapping("/deletebycartId")
	public String deletebycartId(@RequestParam ("cartid") int cartid) {
		return cartService.deletebycartId(cartid);
	}
	@GetMapping("/getcart")
	public List<Cart> getcart(@RequestParam("userid") long userid) {
	    return cartService.getcart(userid); // Change here
	}
	}

     