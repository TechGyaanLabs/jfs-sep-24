package com.careerit.cbook.api;

import com.careerit.cbook.response.ApiResponse;
import com.careerit.cbook.response.ListResponse;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ApiResponse<Contact> addContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.addContact(contact);
        return ApiResponse.success(savedContact);
    }

    @GetMapping("/all")
    public ListResponse<Contact> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ListResponse<>(contacts);
    }

    @GetMapping("/search/{str}")
    public List<Contact> search(@PathVariable(value = "str") String searchTerm) {
        return contactService.searchContacts(searchTerm);
    }

    @PutMapping
    public ApiResponse<Contact> updateContact(@RequestBody Contact contact) {
        return ApiResponse.success(contactService.updateContact(contact));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteContact(@PathVariable(value = "id") UUID id) {
        contactService.deleteContact(id);
        return ApiResponse.success("Contact deleted successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<Contact> getContact(@PathVariable(value = "id") UUID id){
        return ApiResponse.success(contactService.getContact(id));
    }

}
