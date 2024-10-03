package com.careerit.cj.day13;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    public static void main(String[] args) {
        List<Player> players = loadPlayers();
        System.out.println("Total "+players.size()+ " players");

        // Get max paid player(s) names
        List<String> maxPaidPlayers = getMaxPaidPlayers(players);
        System.out.println(maxPaidPlayers);

        // Get min paid player(s) names

    }

    public static List<String> getMaxPaidPlayers(List<Player> players){
            List<String> maxPaidPlayers = new ArrayList<>();
            double maxAmount = maxAmount(players);

            for(Player player:players){
                if(maxAmount == player.getAmount()){
                    maxPaidPlayers.add(player.getName());
                }
            }
            return maxPaidPlayers;
    }


    public static double maxAmount(List<Player> players){
        double max = players.get(0).getAmount();
        for(Player player:players){
            if(max < player.getAmount()){
                max = player.getAmount();
            }
        }
        return max;
    }
    public static double minAmount(List<Player> players){
        double min = players.get(0).getAmount();
        for(Player player:players){
            if(min > player.getAmount()){
                min = player.getAmount();
            }
        }
        return min;
    }


    public static List<Player> loadPlayers() {
        List<Player> players = new ArrayList<>();

        try {
            Path path = Paths.get(ClassLoader.getSystemResource("ipl_players.csv").toURI());
            System.out.println(path);
            List<String> lines = Files.readAllLines(path);
            for (int i = 1; i < lines.size(); i++) {
               String data = lines.get(i);
               String[] arr = data.split(",");
               String name = arr[0];
               String role = arr[1];
               String country = arr[2];
               double amount = Double.parseDouble(arr[3]);
               Player player = new Player(name,role,country,amount);
               players.add(player);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }
}
