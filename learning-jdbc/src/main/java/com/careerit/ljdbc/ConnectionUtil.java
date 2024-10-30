package com.careerit.ljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {

    private static final Properties PROPS = new Properties();

    static {
        try {
            PROPS.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            String url = PROPS.getProperty("url");
            String username = PROPS.getProperty("username");
            String password = PROPS.getProperty("password");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection con){
        try {
            if(con != null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void close( Statement st, Connection con){
        try {
            if(st != null){
                st.close();
            }
            if(con != null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs, Statement st, Connection con){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(con != null){
                con.close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
