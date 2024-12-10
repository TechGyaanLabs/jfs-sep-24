package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class IplStatDaoImpl implements IplStatDao {

    private final PlayerRepository playerRepository;
    private final TeamDetailsRepo teamDetailsRepo;
    private final ObjectMapper objectMapper;

    @Override
    public TeamNames getTeamNames() {
        List<String> names = teamDetailsRepo.findTeamNames();
        return new TeamNames(names);
    }

    @Override
    public List<TeamWithAmountDto> getTeamWithAmount() {
        List<TeamDetails> teamDetailsList = teamDetailsRepo.findAll();
        List<TeamWithAmountDto> teamWithAmountDtoList = new ArrayList<>();
        for(TeamDetails teamDetails: teamDetailsList){
            TeamWithAmountDto teamWithAmountDto = new TeamWithAmountDto();
            teamWithAmountDto.setTeam(teamDetails.getTeam());
            teamWithAmountDto.setAmount(teamDetails.getTotalAmount()-teamDetails.getRemainingAmount());
            teamWithAmountDtoList.add(teamWithAmountDto);
        }
        return teamWithAmountDtoList;
    }

    @Override
    public List<CountryWithPlayerCountDto> getPlayerCountByCountry() {
        List<CountryWithPlayerCountDto> countryWithPlayerCount = playerRepository.findCountryWithPlayerCount();
        log.info("Total {} countries found",countryWithPlayerCount.size());
        return countryWithPlayerCount;
    }

    @Override
    public List<RoleCountDto> getRoleCount() {
        return playerRepository.findRoleCount();
    }

    @Override
    public List<TopPlayerDto> getTopPlayers() {
        List<Object[]> topPlayerDtoList = playerRepository.findTopPlayers();
        log.info("Total {} top players found",topPlayerDtoList.size());
        return convertToTopPlayerDto(topPlayerDtoList);

    }
    @Override
    public TeamStatsDto getTeamStats(String team) {
        List<Object[]> topPlayerDtoList = playerRepository.findTopPlayersOfTeam(team);
        List<TopPlayerDto> topPaidPlayers = convertToTopPlayerDto(topPlayerDtoList);
        List<Object[]> topPlayerDtoListByRole = playerRepository.findTopPlayersOfTeamAndEachRole(team);
        List<TopPlayerDto> topPaidPlayersByRole = convertToTopPlayerDto(topPlayerDtoListByRole);
        List<PlayerDto> players = playerRepository.findPlayersByTeam(team).stream()
                .map(player -> objectMapper.convertValue(player, PlayerDto.class))
                .toList();

        return TeamStatsDto.builder()
                .players(players)
                .topPlayers(topPaidPlayers)
                .topPaidPlayerOfEachRole(
                        topPaidPlayersByRole.stream()
                                .collect(Collectors.groupingBy(TopPlayerDto::getRole)))
                .build();

    }

    private List<TopPlayerDto> convertToTopPlayerDto(List<Object[]> topPlayerDtoList) {
        List<TopPlayerDto> topPlayerDtos = new ArrayList<>();
        for(Object[] obj: topPlayerDtoList){
            TopPlayerDto topPlayerDto = new TopPlayerDto();
            topPlayerDto.setId(UUID.fromString(obj[0].toString()));
            topPlayerDto.setName((String) obj[1]);
            topPlayerDto.setRole((String) obj[2]);
            topPlayerDto.setCountry((String) obj[3]);
            topPlayerDto.setTeam((String) obj[4]);
            topPlayerDto.setPrice((Double) obj[5]);
            topPlayerDtos.add(topPlayerDto);
        }
        return topPlayerDtos;
    }
}
