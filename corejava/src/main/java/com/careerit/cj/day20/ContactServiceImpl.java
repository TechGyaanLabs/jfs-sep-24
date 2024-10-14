package com.careerit.cj.day20;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public String addContact(Contact contact) {
        String id = IdGenerator.getId();
        contact.setId(id);
        contactList.add(contact);
        return id;
    }

    @Override
    public Contact getContact(String id) {
        for (Contact contact : contactList) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact with id : " + id + " not found");
    }

    @Override
    public Contact updateContact(Contact contact) {

         for (Contact c : contactList) {
            if (c.getId().equals(contact.getId())) {
                c.setName(contact.getName());
                c.setEmail(contact.getEmail());
                c.setMobile(contact.getMobile());
                return c;
            }
        }
        throw new IllegalArgumentException("Contact with id : " + contact.getId() + " not found");

    }

    @Override
    public boolean deleteContact(String id) {

        for (Contact contact : contactList) {
            if (contact.getId().equals(id)) {
                contact.setDeleted(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Contact> search(String str) {
        List<Contact> searchList = new ArrayList<>();

        for (Contact contact : contactList) {
            if (searchInContact(str, contact)) {
                searchList.add(contact);
            }
        }
        return searchList;
    }

    private static boolean searchInContact(String str, Contact contact) {
        return contact.getName().contains(str) ||
                contact.getEmail().contains(str) ||
                contact.getMobile().contains(str);
    }

    @Override
    public List<Contact> getContacts() {

        if (contactList.isEmpty()) {
            return List.of();
        }

        List<Contact> activeContacts = new ArrayList<>();

        for (Contact contact : contactList) {
            if (!contact.isDeleted()) {
                activeContacts.add(contact);
            }
        }
        return activeContacts;
    }
}
