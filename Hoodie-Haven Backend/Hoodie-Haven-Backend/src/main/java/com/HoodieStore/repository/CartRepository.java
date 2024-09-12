package com.HoodieStore.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HoodieStore.model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	Optional<Cart> findByproduct_id(Long productId);
}