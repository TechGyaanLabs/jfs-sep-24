package com.careerit.cbook.mappers;

import com.careerit.cbook.domain.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(UUID.fromString(rs.getString("id")));
        contact.setName(rs.getString("name"));
        contact.setMobile(rs.getString("mobile"));
        contact.setEmail(rs.getString("email"));
        contact.setDeleted(rs.getBoolean("deleted"));
        contact.setDob(rs.getDate("dob")!=null?rs.getDate("dob").toLocalDate():null);
        return contact;
    }
}
