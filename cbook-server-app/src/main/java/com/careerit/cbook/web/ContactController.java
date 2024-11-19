package com.careerit.cbook.web;

import com.careerit.cbook.model.Contact;
import com.careerit.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public List<Contact> getContacts(){
        return contactService.getContacts();
    }
    @PostMapping
    public Contact addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }

    @PutMapping
    public Contact updateContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }

    @GetMapping("/by-id/{id}")
    public Contact getContact(@PathVariable UUID id){
        return contactService.getContact(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteContact(@PathVariable UUID id){
        return contactService.deleteContact(id);
    }

    @GetMapping("/search/{str}")
    public List<Contact> searchContacts(@PathVariable String str){
        return contactService.searchContacts(str);
    }
}
