package com.HoodieStore.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.User;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	Optional<Cart> findByproduct_id(Long productId);
	 List<Cart> findByUserId(Long userId);
	 Optional<Cart> findByUserIdAndProductId(long userId, long productId);
	Optional<Cart> findByUser(User user);
}