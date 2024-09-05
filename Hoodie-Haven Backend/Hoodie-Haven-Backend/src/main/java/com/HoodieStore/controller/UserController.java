package com.HoodieStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.User;
import com.HoodieStore.service.UserServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@PostMapping("/usersignup")
	public String registerUser(@RequestBody User user) {
		return userServiceImpl.registerUser(user);
	}
	
	@GetMapping("/userlogin")
	public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		return userServiceImpl.userLogin(username, password);
	}

	
}
