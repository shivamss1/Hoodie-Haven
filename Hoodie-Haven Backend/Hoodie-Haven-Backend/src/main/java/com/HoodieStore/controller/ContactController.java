package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.contactus;
import com.HoodieStore.service.ContactUsServiceimpl;

@CrossOrigin("*")
@RestController
public class ContactController {

    @Autowired
    private ContactUsServiceimpl contactUsServiceImpl;

    @PostMapping("/contact")
    public ResponseEntity<String> submitContactForm(@RequestParam String name,@RequestParam String email,@RequestParam String message ) {
    	contactUsServiceImpl.submitContactForm(name,email,message);
    	return ResponseEntity.ok("form submitted successfully.");
    }
    
    @GetMapping("/getAllContacts")
    public List<contactus> getAllContacts(){
    	return contactUsServiceImpl.getAllContacts();
    }
}