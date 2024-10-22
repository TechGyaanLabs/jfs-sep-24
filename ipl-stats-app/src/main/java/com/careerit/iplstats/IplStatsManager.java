package com.careerit.iplstats;

import com.careerit.iplstats.dto.RoleCountStatsDto;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.IplStatsServiceImpl;

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

        List<RoleCountStatsDto> roleCountStatsDtos = iplStatsService.getRoleCountStats();
        System.out.println(roleCountStatsDtos);


    }

}
