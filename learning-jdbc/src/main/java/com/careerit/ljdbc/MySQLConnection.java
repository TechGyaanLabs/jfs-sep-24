package com.careerit.ljdbc;

import java.sql.*;

public class MySQLConnection {

    public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3306/mysql?allowPublicKeyRetrieval=true&useSSL=false";
            String username = "root";
            String password = "dbuser";
            try{
                Connection con = DriverManager.getConnection(url,username,password);
                String sql = "select id,name from sample";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println(id+" : "+name);
                }
                rs.close();
                st.close();
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
}
