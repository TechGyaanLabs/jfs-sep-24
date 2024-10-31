package com.careerit.ljdbc.iplstats.dataload;

import com.careerit.ljdbc.util.ConnectionUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

public class DataLoaderService {

    public static void main(String[] args) {
            loadData();
    }

    public static void loadData() {

        ObjectMapper mapper = new ObjectMapper();
        try{
            List<TeamDto> teams = mapper.readValue(DataLoaderService.class.getClassLoader().getResourceAsStream("ipl2020.json"), new TypeReference<List<TeamDto>>() {
            });

            for(TeamDto t:teams){
                UUID teamId = UUID.randomUUID();
                insertTeam(t, teamId);
                insertPlayers(t.getPlayers(), teamId);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private static void insertPlayers(List<PlayerDto> players, UUID teamId) {
        String sql = "insert into player (id,name,role,price,team_id) values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionUtil.getConnection();
            pst = con.prepareStatement(sql);
            for(PlayerDto p:players){
                pst.setObject(1, UUID.randomUUID());
                pst.setString(2, p.getName());
                pst.setString(3, p.getRole());
                pst.setDouble(4, p.getPrice());
                pst.setObject(5, teamId);
                pst.addBatch();
            }
            pst.executeBatch();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionUtil.close(pst, con);
        }
    }

    private static void insertTeam(TeamDto t, UUID teamId) {

        String sql = "insert into team (id,name,label,home,coach,city) values(?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConnectionUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setObject(1, teamId);
            pst.setString(2, t.getName());
            pst.setString(3, t.getLabel());
            pst.setString(4, t.getHome());
            pst.setString(5, t.getCoach());
            pst.setString(6, t.getCity());
            pst.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionUtil.close(pst, con);
        }

    }
}
