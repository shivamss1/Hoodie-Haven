package com.HoodieStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.Form;
import com.HoodieStore.service.FormService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class formController {
	@Autowired
	 private FormService fs;
	 @PostMapping("/savedata")
	public String saveformdata(@RequestBody Form form) {
		 fs.saveformdata(form);
		 return "thank you";
	 }
}
