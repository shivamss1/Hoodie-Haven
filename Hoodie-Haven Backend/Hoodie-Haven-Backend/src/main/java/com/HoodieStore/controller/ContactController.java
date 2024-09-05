package com.HoodieStore.controller;

import java.util.List;

import com.HoodieStore.model.contactus;
import com.HoodieStore.repository.ContactRepository;
import com.HoodieStore.service.ContactUsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ContactController {

    @Autowired
    private ContactUsServiceImpl contactUsServiceImpl;

    @PostMapping("/contact")
    public String submitContactForm(@RequestBody contactus contact) {
         return contactUsServiceImpl.submitContactForm(contact);
    }
    @GetMapping("/getAllContacts")
    public List<contactus> getAllContacts(){
    	return contactUsServiceImpl.getAllContacts();
    }
}
