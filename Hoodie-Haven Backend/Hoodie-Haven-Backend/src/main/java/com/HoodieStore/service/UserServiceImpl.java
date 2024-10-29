package com.HoodieStore.service;

import java.util.Arrays;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.User;
import com.HoodieStore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtservice;
	
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

	@Override
	public String userLogin(String username, String password) {
		Authentication auth= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		if(auth.isAuthenticated()) 
			return jwtservice.generateToken(username);
		
	return "Invalid Username or Password!";
		
	}
}