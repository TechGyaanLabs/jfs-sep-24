package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.repo.IplStatDao;
import com.careerit.iplstats.util.ExcelUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatDao iplStatDao;

    private final PlayerService playerService;

    @Override
    public TeamNames getTeamNames() {
         TeamNames teamName = iplStatDao.getTeamNames();
         log.info("Total {} teams found",teamName.teamNames().size());
         return teamName;
    }

    @Override
    public List<TeamWithAmountDto> getTeamWithAmount() {
         List<TeamWithAmountDto> teamWithAmountList = iplStatDao.getTeamWithAmount();
         log.info("Total {} teams found",teamWithAmountList.size());
         return teamWithAmountList;
    }

    @Override
    public List<CountryWithPlayerCountDto> getPlayerCountByCountry() {
        List<CountryWithPlayerCountDto> countryWithPlayerCount = iplStatDao.getPlayerCountByCountry();
        log.info("Total {} countries found",countryWithPlayerCount.size());
        return countryWithPlayerCount;
    }

    @Override
    public List<TopPlayerDto> getTopPlayers() {
        List<TopPlayerDto> topPlayerDtoList = iplStatDao.getTopPlayers();

        log.info("Total {} top players found",topPlayerDtoList.size());
        return topPlayerDtoList;
    }

    @Override
    public List<RoleCountDto> getRoleCount() {
        List<RoleCountDto> roleCountDtoList = iplStatDao.getRoleCount();
        log.info("Total {} roles found",roleCountDtoList.size());
        return roleCountDtoList;
    }

    @Override
    public TeamStatsDto getTeamStats(String team) {
        log.info("Getting team stats");
        return iplStatDao.getTeamStats(team);
    }

    @Override
    public File exportPlayers(String team) {
        List<Player>  players = playerService.findPlayersByTeam(team);
        log.info("Total {} players found for team {}",players.size(),team);
        List<String> headers = List.of("Name","Role","Country","Team","Price");
        List<List<Object>> data = new ArrayList<>();
        for(Player player:players){
            List<Object> row = List.of(player.getName(),player.getRole(),player.getCountry(),player.getTeam(),String.valueOf(player.getPrice()));
            data.add(row);
        }
        String sheet_name = team+"_players";
        String file_name = team+"_players.xlsx";

        ExcelUtil excelUtil = ExcelUtil.builder()
                .headers(headers)
                .data(data)
                .sheetName(sheet_name)
                .fileName(file_name)
                .build();
        return excelUtil.createExcel();
    }
}
