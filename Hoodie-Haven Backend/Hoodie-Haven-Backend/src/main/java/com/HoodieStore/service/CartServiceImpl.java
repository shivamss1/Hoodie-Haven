package com.HoodieStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.Product;
import com.HoodieStore.repository.CartRepository;
import com.HoodieStore.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cr;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart addtocart(int productId) {
        Optional<Product> optionalProduct = productRepository.findById((long) productId);
            Product product = optionalProduct.get();
            Cart cart = new Cart();
             cart.setProduct(product);
            
            
            return cr.save(cart);
      
    }
    public Cart getcartbyId(int CartId) {
    	Optional<Cart> cart=cr.findById(CartId);
		if(cart.isPresent()) {
			return cart.get();
		}
			return new Cart();
    }
    public String deletebycartId(int cartId) {
    	Optional<Cart> cart=cr.findById(cartId);
		if(cart.isPresent()) {
			cr.deleteById(cartId);
			return "cart deleted";
		}
		else {
			return "not present in cart";
		}
			
    }
    public List<Cart> getcart() {
		return cr.findAll();
	}
}