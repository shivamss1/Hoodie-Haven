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
    public String submitContactForm(contactus contact) {
       contactRepository.save(contact);
       return "form submitted & massage recieved";
    }

    @Override
    public List<contactus> getAllContacts() {
        return contactRepository.findAll();
    }
}