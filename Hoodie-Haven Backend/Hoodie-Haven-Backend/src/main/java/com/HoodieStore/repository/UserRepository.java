package com.HoodieStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HoodieStore.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	 User findByusername(String username);

	


}
