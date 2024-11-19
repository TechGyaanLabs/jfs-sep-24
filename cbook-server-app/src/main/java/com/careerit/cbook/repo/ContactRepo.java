package com.careerit.cbook.repo;

import com.careerit.cbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
    List<Contact> findByNameContaining(String str);
}
