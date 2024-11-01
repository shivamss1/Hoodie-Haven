package com.HoodieStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HoodieStore.model.contactus;
import com.HoodieStore.service.ContactUsService;



@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactUsService contactUsServiceImpl;

    @PostMapping("/postcontact")
    public ResponseEntity<String> submitContactForm(@RequestParam String name,@RequestParam String email,@RequestParam String message ) {
   
    	contactUsServiceImpl.submitContactForm(name,email,message);
    	return new ResponseEntity<String>("form submitted successfully.",HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllContacts")
    public ResponseEntity<List<contactus>> getAllContacts(){
    	List<contactus> contacts=contactUsServiceImpl.getAllContacts();
    	if(contacts!=null&&!contacts.isEmpty()) {
    		return new ResponseEntity<List<contactus>>(contacts,HttpStatus.OK);
    	}
    	return new ResponseEntity<List<contactus>>(HttpStatus.NO_CONTENT);
    }
}