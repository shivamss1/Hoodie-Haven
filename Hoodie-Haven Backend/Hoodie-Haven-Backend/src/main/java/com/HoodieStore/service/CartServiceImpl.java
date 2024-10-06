package com.HoodieStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.Product;
import com.HoodieStore.model.User;
import com.HoodieStore.repository.CartRepository;
import com.HoodieStore.repository.ProductRepository;
import com.HoodieStore.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cr;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addtocart(long userId, long productId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return "User not found";
        }

        User user = optionalUser.get();

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            return "Product not found";
        }

        Product product = optionalProduct.get();

        Optional<Cart> cartProduct = cr.findByUserIdAndProductId(userId, productId);
        if (cartProduct.isPresent()) {
            return "Product already present in Cart";
        } else {
            Cart cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cr.save(cart);
            return "Product added successfully in cart";
        }
    } 
    @Override
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
   

    @Override
    public List<Cart> getcart(long userId) {
        return cr.findByUserId(userId); // Change here
    }
	
}