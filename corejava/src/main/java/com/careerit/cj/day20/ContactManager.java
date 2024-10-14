package com.careerit.cj.day20;

import java.util.List;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {

        ContactService service = new ContactServiceDBImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-".repeat(30));
            System.out.println("1.Add contact");
            System.out.println("2.Get contact");
            System.out.println("3.Update contact");
            System.out.println("4.Delete contact");
            System.out.println("5.Search contact");
            System.out.println("6.Display all contacts");
            System.out.println("7.Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1: {
                    Contact contact = getContact();
                    String id = service.addContact(contact);
                    System.out.println("Contact added with id: " + id);
                    break;
                }
                case 2: {
                    System.out.println("Enter the id:");
                    String id = sc.next();
                    try {
                        Contact contact = service.getContact(id);
                        viewContact(contact);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Enter the id:");
                        String id = sc.nextLine();
                        Contact contact = service.getContact(id);
                        System.out.println("Existing contact details:");
                        viewContact(contact);
                        Contact updateContact = getUpdatedContact(contact);
                        Contact updatedContact = service.updateContact(updateContact);
                        viewContact(updatedContact);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter the id:");
                    String id = sc.next();
                    try {
                        boolean isDeleted = service.deleteContact(id);
                        if (isDeleted) {
                            System.out.println("Contact deleted successfully");
                        } else {
                            System.out.println("Contact not found");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter the search string:");
                    String str = sc.next();
                    List<Contact> list = service.search(str);
                    displayContacts(list);
                    break;
                }
                case 6: {
                    List<Contact> list = service.getContacts();
                    displayContacts(list);
                    break;
                }
                case 7: {
                    System.out.println("Thanks for using the application");
                    sc.close();
                    System.exit(0);
                }
            }

        }


    }

    private static Contact getUpdatedContact(Contact contact) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the email:");
        String email = sc.nextLine();
        System.out.println("Enter the mobile:");
        String mobile = sc.nextLine();
        if (name.isBlank()) {
            name = contact.getName();
        }
        if (email.isBlank()) {
            email = contact.getEmail();
        }
        if (mobile.isBlank()) {
            mobile = contact.getMobile();
        }
        contact.setId(contact.getId());
        contact.setName(name);
        contact.setEmail(email);
        contact.setMobile(mobile);
        return contact;

    }

    private static void displayContacts(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("No contacts found");
        }
        for (Contact contact : list) {
            System.out.println(contact.getId() + " " + contact.getName() + " " + contact.getEmail() + " " + contact.getMobile());
        }
    }

    private static void viewContact(Contact contact) {
        if (contact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println(contact.getId() + " " + contact.getName() + " " + contact.getEmail() + " " + contact.getMobile());
        }
    }

    public static Contact getContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the email:");
        String email = sc.nextLine();
        System.out.println("Enter the mobile:");
        String mobile = sc.nextLine();
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setMobile(mobile);
        return contact;
    }
}
