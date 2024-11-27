package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactDao {

        Contact insertContact(Contact contact);
        List<Contact> selectContacts();
        List<Contact> searchContacts(String str);
        Optional<Contact> selectContact(UUID id);
        Contact updateContact(Contact contact);

        boolean deleteContact(UUID id);

        int insertContacts(List<Contact> contacts);

        boolean isContactExists(String mobile);
}
