package com.careerit.ljdbc.cbook;

import com.careerit.ljdbc.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService{
    @Override
    public long addContact(Contact contact) {

        return 0;
    }

    @Override
    public Contact getContact(long id) {
        return null;
    }

    @Override
    public boolean deleteContact(long id) {
        return false;
    }

    @Override
    public boolean updateContact(Contact contact) {
        return false;
    }

    @Override
    public List<Contact> getContacts() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Contact> list = new ArrayList<>();
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(ContactQueries.GET_CONTACTS);
            while(rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getLong("id"));
                contact.setName(rs.getString("name"));
                contact.setDob(rs.getDate("dob").toLocalDate());
                contact.setEmail(rs.getString("email"));
                contact.setMobile(rs.getString("mobile"));
                contact.setCity(rs.getString("city"));
                list.add(contact);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionUtil.close(rs, st, con);
        }
        return list;
    }

    @Override
    public List<Contact> search(String str) {
        return null;
    }
}
