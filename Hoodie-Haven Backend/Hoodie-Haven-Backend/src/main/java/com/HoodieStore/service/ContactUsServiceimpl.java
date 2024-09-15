package com.HoodieStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.contactus;
import com.HoodieStore.repository.ContactRepository;

@Service
public class ContactUsServiceimpl implements ContactUsService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void submitContactForm(String name,String email,String message) {
    	contactus contact=new contactus();
    	contact.setName(name);
    	contact.setEmail(email);
    	contact.setMessage(message);
       contactRepository.save(contact);
    }

    @Override
    public List<contactus> getAllContacts() {
        return contactRepository.findAll();
    }
}