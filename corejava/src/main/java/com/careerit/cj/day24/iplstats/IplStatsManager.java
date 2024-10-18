package com.careerit.cj.day24.iplstats;

import java.util.List;

public class IplStatsManager {

    public static void main(String[] args) {

        IplStatService service = new IplStatServiceImpl();

        List<String> teamLabels = service.teamLabels();
        System.out.println("Team labels are :");
        teamLabels.forEach(System.out::println);
        String teamLabel = "CSK";
        List<PlayerDetails> players = service.players(teamLabel);
        System.out.println("Team has " + players.size() + " players");
    }
}
