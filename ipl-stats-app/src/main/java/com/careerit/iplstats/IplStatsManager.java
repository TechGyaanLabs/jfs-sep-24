package com.careerit.iplstats;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.IplStatsServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IplStatsManager {

    public static void main(String[] args) {

        IplStatsService iplStatsService = new IplStatsServiceImpl();
//        List<TeamBasicDto> teamNames = iplStatsService.getTeamNames();
//        for (TeamBasicDto teamBasicDto : teamNames) {
//            System.out.println(teamBasicDto.getName() + " : " + teamBasicDto.getLabel());
//        }

        /*List<TeamAmountStatsDto> teamAmountStats = iplStatsService.getTeamAmountStats();
        for (TeamAmountStatsDto teamAmountStatsDto : teamAmountStats) {
            System.out.println(teamAmountStatsDto.getName() + " : " + teamAmountStatsDto.getLabel() + " : " + teamAmountStatsDto.getAmount());
        }*/

        /*List<RoleCountStatsDto> roleCountStatsDtos = iplStatsService.getRoleCountStats();
        System.out.println(roleCountStatsDtos);*/


        List<PlayerDto> allPlayers = iplStatsService.getAllPlayers();


        allPlayers.stream()
                .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                .limit(3)
                .forEach(System.out::println);

        List<String> names = new ArrayList<>();
        names.add("Sachin");
        names.add("Dhoni");
        names.add("Virat");
        names.add("Rohit");
        names.add("Dhawan");
        names.add("Rahul");


      Collections.sort(allPlayers, Comparator.comparing(PlayerDto::getName)
                .thenComparing(PlayerDto::getPrice).reversed());
        for(PlayerDto playerDto:allPlayers) {
            System.out.println(playerDto.getName()+" : "+playerDto.getPrice());
        }

    }


}