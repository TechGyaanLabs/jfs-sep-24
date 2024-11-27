package com.careerit.cbook.api;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contact")
@RequiredArgsConstructor
public class ContactController {

        private final ContactService contactService;
        @PostMapping
        public Contact addContact(@RequestBody Contact contact){
            return contactService.addContact(contact);
        }

        @GetMapping("/all")
        public List<Contact> getContacts(){
            return contactService.getContacts();
        }

        @GetMapping("/search/{str}")
        public List<Contact> search(@PathVariable(value = "str")  String searchTerm){
            return contactService.searchContacts(searchTerm);
        }

}
