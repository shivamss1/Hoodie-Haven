package com.HoodieStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HoodieStore.model.Cart;
import com.HoodieStore.model.Form;

public interface FormRepository extends JpaRepository<Form, Long>{

}
