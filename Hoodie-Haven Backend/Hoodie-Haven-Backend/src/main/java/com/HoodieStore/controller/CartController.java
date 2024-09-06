package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.Product;
import com.HoodieStore.service.CartService;

@RestController
public class CartController {
	@Autowired
   private CartService cartService;
	
	@PostMapping("/addToCart")
	public Cart addtocart(int productId) {
		return cartService.addtocart(productId);
	}
	@GetMapping("/getcartbyId")
	public Cart getcartbyId(int cartId) {
		return cartService.getcartbyId(cartId);
	}
	@DeleteMapping("/deletebycartId")
	public String deletebycartId(@RequestParam ("cartid") int cartid) {
		return cartService.deletebycartId(cartid);
	}
	@GetMapping("/getcart")
		public List<Cart> getcart(){
			return cartService.getcart();
		}
	}

