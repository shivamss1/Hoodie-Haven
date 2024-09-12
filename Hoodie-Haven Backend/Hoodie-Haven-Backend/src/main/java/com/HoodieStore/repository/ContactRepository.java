package com.HoodieStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HoodieStore.model.contactus;

@Repository
public interface ContactRepository extends JpaRepository<contactus, Long> {

}