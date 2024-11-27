package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.mappers.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ContactDaoImpl implements ContactDao{

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Contact insertContact(Contact contact) {
        String query = "insert into contact(id,name,email,dob,mobile) values(?,?,?,?,?)";
        UUID id = UUID.randomUUID();
        jdbcTemplate.update(query, ps -> {
            ps.setObject(1,id);
            ps.setString(2,contact.getName());
            ps.setString(3,contact.getEmail());
            ps.setObject(4,contact.getDob());
            ps.setString(5,contact.getMobile());
        });
        contact.setId(id);
        return contact;
    }

    @Override
    public List<Contact> selectContacts() {
        String query = "select id,name,email,dob,mobile,deleted from contact where deleted=false";
        return jdbcTemplate.query(query, new ContactRowMapper());
    }

    @Override
    public List<Contact> searchContacts(String str) {
        String query =  "select id,name,email,dob,mobile,deleted from contact where deleted=false and name ilike ?";
        return jdbcTemplate.query(query,
                ps -> ps.setString(1,"%"+str+"%"),
                new ContactRowMapper());
    }

    @Override
    public Optional<Contact> selectContact(UUID id) {
        String query = "select id,name,email,dob,mobile,deleted from contact where deleted=false and id = ?";
        List<Contact> contacts = jdbcTemplate.query(query,(ps)->{
            ps.setObject(1,id);
        },new ContactRowMapper());
        return contacts.size() == 1 ? Optional.of(contacts.getFirst()):Optional.empty();
    }
    @Override
    public Contact updateContact(Contact contact) {
        String query = "update contact set name=:name , email=:email, mobile =: mobile where id =:id";

        Map<String,Object> map = Map.of(
                "name",contact.getName(),
                "email",contact.getEmail(),
                "mobile",contact.getMobile(),
                "id",contact.getId());

        namedParameterJdbcTemplate.update(query,map);
        Optional<Contact> updatedContact = selectContact(contact.getId());
        return updatedContact.orElse(null);
    }

    @Override
    public boolean deleteContact(UUID id) {
        return  deleteContactInternal(id,false);
    }


    @Override
    public int insertContacts(List<Contact> contacts) {
        String query = "INSERT INTO contact (id, name, email, dob, mobile) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(query, contacts, contacts.size(), (ps, contact) -> {
            UUID id = UUID.randomUUID();
            ps.setObject(1, id);
            ps.setString(2, contact.getName());
            ps.setString(3, contact.getEmail());
            ps.setObject(4, contact.getDob());
            ps.setString(5, contact.getMobile());
            contact.setId(id);
        });
        log.info("Total {} contacts are added ",contacts.size());
        return contacts.size();
    }

    @Override
    public boolean isContactExists(String mobile) {
        Long count = jdbcTemplate.queryForObject("select count(*) from contact where deleted = false and mobile = ?",Long.class,mobile);
        return count != null && count > 0;
    }

    private boolean deleteContactInternal(UUID id, boolean hardDelete) {
        String query = hardDelete
                ? "DELETE FROM contact WHERE id = ?"
                : "UPDATE contact SET deleted = true WHERE id = ?";
        int count = jdbcTemplate.update(query, id);
        return count > 0;
    }
}
