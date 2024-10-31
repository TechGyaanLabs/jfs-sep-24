package com.careerit.ljdbc.cbook;

public final class ContactQueries {

        private ContactQueries() {
        }

        public static final String ADD_CONTACT = "insert into contact(name,dob,email,mobile,city) values(?,?,?,?,?)";
        public static final String GET_CONTACT = "select id,name,dob,email,mobile,city from contact where id = ? and deleted = false";
        public static final String DELETE_CONTACT = "update contact set deleted = true where id = ?";

        public static final String UPDATE_CONTACT = "update contact set name = ?,dob = ?,email = ?,mobile = ?,city = ? where id = ?";

        public static final String GET_CONTACTS = "select id,name,dob,email,mobile,city from contact where deleted = false";

        public static final String SEARCH_CONTACTS = "select id,name,dob,email,mobile,city from contact where deleted = false and (name like ? or email like ? or mobile like ? or city like ?)";
}
