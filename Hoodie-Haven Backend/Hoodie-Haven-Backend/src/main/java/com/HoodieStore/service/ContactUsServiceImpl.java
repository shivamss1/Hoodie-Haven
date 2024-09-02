package com.HoodieStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.contactus;
import com.HoodieStore.repository.ContactRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public contactus submitContactForm(contactus contact) {
       return contactRepository.save(contact);
    }

    @Override
    public List<contactus> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public contactus getContactById(Long id) {
        Optional<contactus> contact = contactRepository.findById(id);
        return contact.orElseGet(contactus::new); 
    }

    @Override
    public String deleteContact(Long id) {
        contactRepository.deleteById(id);
        return "Contact has been successfully deleted.";
    }
}
