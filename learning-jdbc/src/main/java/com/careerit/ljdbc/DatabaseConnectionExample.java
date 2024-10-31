package com.careerit.ljdbc;

import com.careerit.ljdbc.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionExample {
    public static void main(String[] args) {

        //createTable();
        //insertRecords();
        //loadPlayers();
        showPlayers();
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


    static String jsonData = """
            [
              { "name": "Virat Kohli", "team": "RCB", "runs": 6624, "wickets": 4 },
              { "name": "MS Dhoni", "team": "CSK", "runs": 5037, "wickets": 0 },
              { "name": "Rohit Sharma", "team": "MI", "runs": 5879, "wickets": 15 },
              { "name": "Suresh Raina", "team": "CSK", "runs": 5528, "wickets": 25 },
              { "name": "David Warner", "team": "DC", "runs": 5881, "wickets": 1 },
              { "name": "KL Rahul", "team": "PBKS", "runs": 3273, "wickets": 0 },
              { "name": "Shikhar Dhawan", "team": "PBKS", "runs": 6244, "wickets": 4 },
              { "name": "Chris Gayle", "team": "PBKS", "runs": 4965, "wickets": 18 },
              { "name": "AB de Villiers", "team": "RCB", "runs": 5162, "wickets": 2 },
              { "name": "Andre Russell", "team": "KKR", "runs": 2035, "wickets": 74 },
              { "name": "Hardik Pandya", "team": "MI", "runs": 1476, "wickets": 42 },
              { "name": "Kieron Pollard", "team": "MI", "runs": 3412, "wickets": 69 },
              { "name": "Rashid Khan", "team": "SRH", "runs": 104, "wickets": 112 },
              { "name": "Jasprit Bumrah", "team": "MI", "runs": 52, "wickets": 145 },
              { "name": "Yuzvendra Chahal", "team": "RR", "runs": 65, "wickets": 139 },
              { "name": "Bhuvneshwar Kumar", "team": "SRH", "runs": 96, "wickets": 154 },
              { "name": "Ravindra Jadeja", "team": "CSK", "runs": 2386, "wickets": 127 },
              { "name": "Shane Watson", "team": "CSK", "runs": 3874, "wickets": 92 },
              { "name": "Sunil Narine", "team": "KKR", "runs": 1025, "wickets": 147 },
              { "name": "Dwayne Bravo", "team": "CSK", "runs": 1537, "wickets": 183 },
              { "name": "Moeen Ali", "team": "CSK", "runs": 910, "wickets": 21 },
              { "name": "Pat Cummins", "team": "KKR", "runs": 196, "wickets": 45 },
              { "name": "Kagiso Rabada", "team": "DC", "runs": 84, "wickets": 97 },
              { "name": "Ishant Sharma", "team": "DC", "runs": 79, "wickets": 72 },
              { "name": "Prithvi Shaw", "team": "DC", "runs": 1588, "wickets": 0 },
              { "name": "Shubman Gill", "team": "GT", "runs": 1417, "wickets": 0 },
              { "name": "Ruturaj Gaikwad", "team": "CSK", "runs": 1207, "wickets": 0 },
              { "name": "Sanju Samson", "team": "RR", "runs": 3123, "wickets": 0 },
              { "name": "Ben Stokes", "team": "RR", "runs": 920, "wickets": 28 },
              { "name": "Axar Patel", "team": "DC", "runs": 1104, "wickets": 95 }
            ]
                       
            
            """;

    public static void loadPlayers(){
        String sql = "insert into player(name,team,runs,wickets) values(?,?,?,?)";
        List<Player> players = getPlayers();
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = ConnectionUtil.getConnection();
            pst = con.prepareStatement(sql);
            for(Player player:players){
                pst.setString(1,player.getName());
                pst.setString(2,player.getTeam());
                pst.setLong(3,player.getRuns());
                pst.setLong(4,player.getWickets());
                pst.addBatch();
            }

            System.out.println("Records inserted successfully");
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(pst, con);
        }

    }

    private static void showPlayers() {
        String sql = "select id,name,team,runs,wickets from player";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Player> players = new ArrayList<>();
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String team = rs.getString("team");
                long runs = rs.getLong("runs");
                long wickets = rs.getLong("wickets");
                Player player = Player.builder()
                        .id(id)
                        .name(name)
                        .team(team)
                        .runs(runs)
                        .wickets(wickets)
                        .build();
                players.add(player);
            }
            printPlayers(players);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(st, con);
        }
    }

    private static void printPlayers(List<Player> players) {

        for(Player player:players){
            System.out.println(player.getId()+" "+player.getName()+" "+player.getTeam()+" "+player.getRuns()+" "+player.getWickets());
        }
    }

    private static List<Player> getPlayers(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Player>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
