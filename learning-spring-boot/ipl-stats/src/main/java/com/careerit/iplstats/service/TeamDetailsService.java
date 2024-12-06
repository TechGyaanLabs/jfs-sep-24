package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.TeamDetailsDto;

import java.util.List;

public interface TeamDetailsService {

    TeamDetailsDto addTeam(TeamDetailsDto teamDetailsDto);
    List<TeamDetailsDto> getTeamDetails();

    List<TeamDetailsDto> addTeams(List<TeamDetailsDto> teamDetailsDtoList);
}
