package com.HoodieStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.User;
import com.HoodieStore.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userServiceImpl;


	@PostMapping("/usersignup")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
	
			String msg=userServiceImpl.registerUser(user);
			if (msg.equalsIgnoreCase("User Already exists")) {
				return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>(msg,HttpStatus.CREATED);		
			}

	}

	@PostMapping("/login")
	public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		return userServiceImpl.userLogin(username, password);
	}


}