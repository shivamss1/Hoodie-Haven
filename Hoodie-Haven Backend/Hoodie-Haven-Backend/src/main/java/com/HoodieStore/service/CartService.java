package com.HoodieStore.service;


import java.util.List;

import com.HoodieStore.model.Cart;

public interface CartService {
	 Cart addtocart(long productId);
	 String deletebycartId(int cartId);
	  List<Cart> getcart();
	
	
}
