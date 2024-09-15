package com.HoodieStore.service;

import java.util.List;
import com.HoodieStore.model.contactus;

public interface ContactUsService {
    void submitContactForm(String name,String email,String message);
    List<contactus> getAllContacts();
}