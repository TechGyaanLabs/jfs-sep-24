package com.careerit.cbook.service;

import com.careerit.cbook.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {

        Contact addContact(Contact contact);
        Contact updateContact(Contact contact);
        Contact getContact(UUID id);
        boolean deleteContact(UUID id);
        List<Contact> getContacts();
        List<Contact> searchContacts(String str);
}
