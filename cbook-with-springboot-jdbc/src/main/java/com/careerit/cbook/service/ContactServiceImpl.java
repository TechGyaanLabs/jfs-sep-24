package com.careerit.cbook.service;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.exception.ContactAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService{

    private final ContactDao contactDao;

    @Override
    public Contact addContact(Contact contact) {
        Assert.notNull(contact,"Contact object shouldn't be null");
        Assert.notNull(contact.getName(),"Name can't be empty");
        Assert.notNull(contact.getMobile(),"Mobile can't be empty");
        if(contactDao.isContactExists(contact.getMobile())){
            log.info("Contact with mobile {} already exists",contact.getMobile());
            throw new ContactAlreadyExistsException("Contact with mobile "+contact.getMobile()+" already exists");
        }else{
            Contact savedContact = contactDao.insertContact(contact);
            log.info("Contact id added with id {}, name {} and mobile {}",savedContact.getId(),savedContact.getName(),savedContact.getMobile());
            return savedContact;
        }
    }

    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = contactDao.selectContacts();
        log.info("Active contact count is :{}",contacts.size());
        return contacts;
    }

    @Override
    public List<Contact> searchContacts(String str) {
        if(StringUtils.hasText(str)){
            List<Contact> contacts =  contactDao.searchContacts(str);
            log.info("For given search term {} has contacts {}",str,contacts.size());
            return contacts;
        }
        log.info("Search term is empty");
        return contactDao.selectContacts();
    }

    @Override
    public Optional<Contact> getContact(UUID id) {
        return Optional.empty();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public boolean deleteContact(UUID id) {
        return false;
    }

    @Override
    public int addContacts(List<Contact> contacts) {
        return 0;
    }
}
