package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleCountStatsDto;
import com.careerit.iplstats.dto.TeamAmountStatsDto;
import com.careerit.iplstats.dto.TeamBasicDto;

import java.util.List;
import java.util.Set;

public interface IplStatsService {

        List<TeamAmountStatsDto> getTeamAmountStats();
        List<RoleCountStatsDto>  getRoleCountStats();
        List<PlayerDto> getTop3AmountPaidPlayers();
        List<TeamBasicDto> getTeamNames();
        Set<String> getRoles();
        List<PlayerDto> getPlayersByTeam(String teamName);
        List<PlayerDto> getPlayersByRole(String role);
        List<PlayerDto> getPlayersByTeamAndRole(String teamName,String role);
        List<PlayerDto> sortByField(String field);

}
