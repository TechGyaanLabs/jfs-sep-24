package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleCountStatsDto;
import com.careerit.iplstats.dto.TeamAmountStatsDto;
import com.careerit.iplstats.dto.TeamBasicDto;
import com.careerit.iplstats.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class IplStatsServiceImpl implements IplStatsService {


    private List<TeamDetails> teamDetailsList;
    private final String FILE_NAME = "ipl2020.json";

    private Map<String, List<Player>> teamPlayerMap;
    private Map<String,TeamDetails> teamDetailsMap;

    public IplStatsServiceImpl() {
        init();
    }

    private void init() {
        this.teamDetailsList = JsonUtil.getObjectFromFile(FILE_NAME,
                new TypeReference<List<TeamDetails>>() {
                });
        this.teamDetailsMap = new HashMap<>();
        this.teamPlayerMap = new HashMap<>();
        if(teamDetailsList != null) {
            for (TeamDetails teamDetails : teamDetailsList) {
                teamDetailsMap.put(teamDetails.getLabel(), teamDetails);
                teamPlayerMap.put(teamDetails.getLabel(), teamDetails.getPlayers());
            }
        }
    }

    @Override
    public List<TeamAmountStatsDto> getTeamAmountStats() {
        return teamDetailsList
                .stream()
                .map(teamDetails -> {
                    double amount = teamDetails.getPlayers().stream().mapToDouble(Player::getPrice).sum();
                    return new TeamAmountStatsDto(teamDetails.getName(),teamDetails.getLabel(),amount);
                }).toList();
    }

    @Override
    public List<RoleCountStatsDto> getRoleCountStats() {
        return teamPlayerMap.values()
                .stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(Player::getRole, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new RoleCountStatsDto(entry.getKey(),entry.getValue())).toList();
    }

    @Override
    public List<PlayerDto> getTop3AmountPaidPlayers() {
        return null;
    }

    @Override
    public List<TeamBasicDto> getTeamNames() {
        List<TeamBasicDto> teamBasicDtoList = new ArrayList<>();
        for (TeamDetails teamDetails : teamDetailsList) {
            TeamBasicDto teamBasicDto = new TeamBasicDto();
            teamBasicDto.setName(teamDetails.getName());
            teamBasicDto.setLabel(teamDetails.getLabel());
            teamBasicDtoList.add(teamBasicDto);
        }
        return teamBasicDtoList;
    }

    @Override
    public Set<String> getRoles() {
        return null;
    }

    @Override
    public List<PlayerDto> getPlayersByTeam(String teamName) {
        return null;
    }

    @Override
    public List<PlayerDto> getPlayersByRole(String role) {
        return null;
    }

    @Override
    public List<PlayerDto> getPlayersByTeamAndRole(String teamName, String role) {
        return null;
    }

    @Override
    public List<PlayerDto> sortByField(String field) {
        return null;
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<PlayerDto> playerDtoList = new ArrayList<>();

        teamDetailsList.forEach(teamDetails -> {
            List<Player> players = teamDetails.getPlayers();
            for (Player player : players) {
                PlayerDto playerDto = new PlayerDto();
                playerDto.setName(player.getName());
                playerDto.setRole(player.getRole());
                playerDto.setPrice(player.getPrice());
                playerDto.setTeamName(teamDetails.getName());
                playerDto.setTeamLabel(teamDetails.getLabel());
                playerDtoList.add(playerDto);
            }
        });
        return playerDtoList;
    }

}
