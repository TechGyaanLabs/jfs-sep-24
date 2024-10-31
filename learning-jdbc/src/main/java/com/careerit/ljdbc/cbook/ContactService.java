package com.careerit.ljdbc.cbook;

import java.util.List;

public interface ContactService {

        long addContact(Contact contact);
        Contact getContact(long id);
        boolean deleteContact(long id);
        boolean updateContact(Contact contact);
        List<Contact> getContacts();
        List<Contact> search(String str);

}
