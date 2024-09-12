package com.HoodieStore.service;


import java.util.List;
import java.util.Optional;

import com.HoodieStore.model.Cart;

public interface CartService {
	 String addtocart(long productId);
	 String deletebycartId(int cartId);
	  List<Cart> getcart();
	
	
}
