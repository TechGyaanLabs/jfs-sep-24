package com.careerit.cj.day20;

import java.util.List;

public interface ContactService {

    String addContact(Contact contact);

    Contact getContact(String id);

    Contact updateContact(Contact contact);

    boolean deleteContact(String id);

    List<Contact> search(String str);

    List<Contact> getContacts();
}
