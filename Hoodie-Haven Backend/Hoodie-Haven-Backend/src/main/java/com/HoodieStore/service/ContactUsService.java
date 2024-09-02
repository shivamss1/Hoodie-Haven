package com.HoodieStore.service;

import java.util.List;
import com.HoodieStore.model.contactus;

public interface ContactUsService {
    String submitContactForm(contactus contact);
    List<contactus> getAllContacts();
}
