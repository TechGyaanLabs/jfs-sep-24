package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;

import java.io.File;
import java.util.List;

public interface IplStatsService {
    TeamNames getTeamNames();
    List<TeamWithAmountDto> getTeamWithAmount();
    List<CountryWithPlayerCountDto> getPlayerCountByCountry();

    List<TopPlayerDto> getTopPlayers();

    List<RoleCountDto> getRoleCount();

    TeamStatsDto getTeamStats(String team);

    File exportPlayers(String team);
    File exportAllPlayers();

    File exportPdfPlayers(String team);
    File exportPdfAllPlayers();
}
