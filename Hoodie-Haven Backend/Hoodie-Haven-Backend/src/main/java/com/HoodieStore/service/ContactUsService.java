package com.HoodieStore.service;

import java.util.List;
import com.HoodieStore.model.contactus;

public interface ContactUsService {
    contactus submitContactForm(contactus contact);
    List<contactus> getAllContacts();
    contactus getContactById(Long id);
    String deleteContact(Long id);
}
