package com.HoodieStore.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.User;
import com.HoodieStore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String registerUser(User user) {
	 User extistusername= userRepository.findByusername(user.getUsername());
	if(extistusername!=null){
		 return "User Already exists";
	 }else {
		 user.setRoles(Arrays.asList("ROLE_USER"));
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 userRepository.save(user);
		 return "User Registered Successfully.";
	 }
	}

//	@Override
//	public String userLogin(String username, String password) {
//		User user=userRepository.findByusername(username);
//		if(user!=null) {
//			if(user.getPassword().equals(password)) {
//				return "Login Successfully.";
//			}else {
//				return "Incorrect Username or Password.";
//			}
//		}else {
//			return "Incorrect Username or Password.";
//		}
//	}
}