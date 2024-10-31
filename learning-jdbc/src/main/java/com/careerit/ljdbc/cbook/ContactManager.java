package com.careerit.ljdbc.cbook;

import java.util.List;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {

        ContactService contactService = new ContactServiceImpl();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Add Contact 2.Update Contact 3.Delete Contact 4.Search Contact 5.Show All Contacts 6.Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch){
                case 1: addContact(contactService,sc);
                        break;
                case 2: updateContact(contactService,sc);
                        break;
                case 3: deleteContact(contactService,sc);
                        break;
                case 4: searchContact(contactService,sc);
                        break;
                case 5: showContacts(contactService.getContacts());
                        break;
                case 6: System.exit(0);
            }

        }

    }

    private static void searchContact(ContactService contactService, Scanner sc) {
    }

    private static void deleteContact(ContactService contactService, Scanner sc) {
    }

    private static void updateContact(ContactService contactService, Scanner sc) {
    }

    private static void addContact(ContactService contactService, Scanner sc) {
    }


    private static void showContacts(List<Contact> list) {

        if (list.isEmpty()) {
            System.out.println("No contacts found");
        } else {
            System.out.println("Id\tName\tDOB\tEmail\tMobile\tCity");
            System.out.println("------------------------------------------------------------");
            for (Contact contact : list) {
                System.out.println(contact.getId() + "\t" + contact.getName() + "\t" + contact.getDob() + "\t" + contact.getEmail() + "\t" + contact.getMobile() + "\t" + contact.getCity());
            }
        }
    }
}
