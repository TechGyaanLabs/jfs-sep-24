package com.careerit.ljdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionExample {
    public static void main(String[] args) {

        //createTable();
        insertRecords();
    }


    // 1. Create table app_user with columns id,username,password,role
    // 2. Insert 3 records into app_user table
    // 3. Select all records from app_user table
    // 4. Update password for user with id 1
    // 5. Delete user with id 2

    // liquibase or flyway



    public static void createTable() {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionUtil.getConnection();
            String sql = "create table app_user(id serial primary key,username varchar(50),password varchar(50),role varchar(50))";
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionUtil.close(con);
        }
    }

    public static void insertRecords() {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            String sql1 = "insert into app_user(username,password,role) values('krish','krish123','admin')";
            String sql2 = "insert into app_user(username,password,role) values('manoj','manoj123','user')";
            String sql3 = "insert into app_user(username,password,role) values('sai','sai123','user')";
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.addBatch(sql3);
            st.executeBatch();
            System.out.println("Records inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionUtil.close(con);
        }
    }

    public static void insertRecord(){
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            String sql = "insert into app_user(username,password,role) values('krish','krish123','admin')";
            st.executeUpdate(sql);
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionUtil.close(con);
        }
    }

}
