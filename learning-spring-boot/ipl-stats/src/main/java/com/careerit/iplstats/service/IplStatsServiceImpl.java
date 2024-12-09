package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.repo.IplStatDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatDao iplStatDao;

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
}
