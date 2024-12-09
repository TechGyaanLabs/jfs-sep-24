package com.careerit.iplstats.repo;


import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;

import java.util.List;

public interface IplStatDao {

    TeamNames getTeamNames();
    List<TeamWithAmountDto> getTeamWithAmount();
    List<CountryWithPlayerCountDto> getPlayerCountByCountry();
    List<RoleCountDto> getRoleCount();
    List<TopPlayerDto> getTopPlayers();

    TeamStatsDto getTeamStats(String team);


}
