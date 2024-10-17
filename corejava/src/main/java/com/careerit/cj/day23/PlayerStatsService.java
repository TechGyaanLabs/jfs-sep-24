package com.careerit.cj.day23;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatsService {


    public List<Player> loadPlayers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Player> list = mapper.readValue(PlayerStatsService
                            .class.getResourceAsStream("/players.json"),
                    new TypeReference<List<Player>>() {
                    });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        PlayerStatsService service = new PlayerStatsService();
        List<Player> list = service.loadPlayers();

        // Get Max Paid Player


        // Get Total Team Amount


        // Get Players name of the given team

        String teamName = "RCB";

        List<String> players = new ArrayList<>();
        for(Player player:list) {
            if(player.getTeamName().equals(teamName)){
                players.add(player.getName());
            }
        }

        System.out.println(players);







    }

}
