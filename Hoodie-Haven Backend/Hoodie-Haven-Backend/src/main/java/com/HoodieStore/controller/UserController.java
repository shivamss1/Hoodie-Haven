package com.HoodieStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.User;
import com.HoodieStore.service.UserServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;


	@PostMapping("/usersignup")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		try {
			return new ResponseEntity(userServiceImpl.registerUser(user),HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		} 
	}

	@GetMapping("/userlogin")
	public ResponseEntity<String> userLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		return new ResponseEntity(userServiceImpl.userLogin(username, password),HttpStatus.OK);
	}


}