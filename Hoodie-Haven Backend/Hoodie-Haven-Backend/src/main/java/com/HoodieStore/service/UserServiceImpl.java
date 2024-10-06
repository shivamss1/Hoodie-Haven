package com.HoodieStore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.User;
import com.HoodieStore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public String registerUser(User user) {
	 Optional<User> extistusername= userRepository.findByusername(user.getUsername());
	if(extistusername.isPresent()){
		 return "User Already exists";
	 }else {
		 userRepository.save(user);
		 return "User Registered Successfully.";
	 }
	}

	@Override
	public String userLogin(String username, String password) {
		Optional <User> user=userRepository.findByusername(username);
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				String userId = String.valueOf(user.get().getId());  
				return "Login Successfully. User ID: " + userId;
			
			}else {
				return "Incorrect Username or Password.";
			}
		}else {
			return "Incorrect Username or Password.";
		}
	}
}