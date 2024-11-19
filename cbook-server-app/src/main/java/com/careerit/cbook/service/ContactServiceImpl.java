package com.careerit.cbook.service;

import com.careerit.cbook.model.Contact;
import com.careerit.cbook.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepo contactRepo;
    @Override
    public Contact addContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public Contact getContact(UUID id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteContact(UUID id) {
        contactRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @Override
    public List<Contact> searchContacts(String str) {
        return contactRepo.findByNameContaining(str);
    }
}
