package com.HoodieStore.controller;

package com.HoodieStore.controller;

import com.example.contactus.entity.Contact;
import com.example.contactus.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public ResponseEntity<String> submitContactForm(@RequestBody Contact contact) {
        // Save the contact to the database
        contactRepository.save(contact);

        return new ResponseEntity<>("Message received and saved successfully!", HttpStatus.OK);
    }
}
