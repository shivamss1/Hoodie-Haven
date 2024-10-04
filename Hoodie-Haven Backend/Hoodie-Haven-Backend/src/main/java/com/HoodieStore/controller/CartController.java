package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Cart;
import com.HoodieStore.service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
   private CartService cartService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addtocart(long productId) {
		return new ResponseEntity(cartService.addtocart(productId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletebycartId")
	public ResponseEntity<String> deletebycartId(@RequestParam ("cartid") int cartid) {
		return new ResponseEntity(cartService.deletebycartId(cartid),HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getcart")
		public ResponseEntity<List<Cart>> getcart(){
			List<Cart> cart= cartService.getcart();
			if(cart!=null&&!cart.isEmpty()) {
				return new ResponseEntity(cart,HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

