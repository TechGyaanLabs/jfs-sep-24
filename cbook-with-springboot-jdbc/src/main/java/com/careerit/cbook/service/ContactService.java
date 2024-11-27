package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactService {
    Contact addContact(Contact contact);
    List<Contact> getContacts();
    List<Contact> searchContacts(String str);
    Optional<Contact> getContact(UUID id);
    Contact updateContact(Contact contact);
    boolean deleteContact(UUID id);
    int addContacts(List<Contact> contacts);
}
