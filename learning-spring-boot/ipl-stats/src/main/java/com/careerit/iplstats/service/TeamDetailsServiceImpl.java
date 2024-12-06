package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.TeamDetailsDto;
import com.careerit.iplstats.exception.TeamAlreadyExistsException;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamDetailsServiceImpl implements TeamDetailsService {

    private final TeamDetailsRepo teamDetailsRepo;
    private final ObjectMapper objectMapper;

    @Override
    public TeamDetailsDto addTeam(TeamDetailsDto teamDetailsDto) {
        Assert.notNull(teamDetailsDto, "Team details should not be null");
        Assert.hasText(teamDetailsDto.getName(), "Team name should not be null or empty");
        Assert.hasText(teamDetailsDto.getTeam(), "Team should not be null or empty");
        if (isTeamExists(teamDetailsDto.getTeam())) {
            throw new TeamAlreadyExistsException("Team " + teamDetailsDto.getTeam() + " already exists");
        }
        TeamDetails teamDetails = objectMapper.convertValue(teamDetailsDto, TeamDetails.class);
        TeamDetails savedTeamDetails = teamDetailsRepo.save(teamDetails);
        teamDetailsDto = objectMapper.convertValue(savedTeamDetails, TeamDetailsDto.class);
        log.info("Team {} added successfully", teamDetailsDto.getTeam());
        return teamDetailsDto;
    }

    private boolean isTeamExists(String team) {
        Optional<TeamDetails> optionalTeamDetails = teamDetailsRepo.findByTeam(team);
        return optionalTeamDetails.isPresent();
    }

    @Override
    public List<TeamDetailsDto> getTeamDetails() {
        List<TeamDetails> teamDetailsList = teamDetailsRepo.findAll();
        List<TeamDetailsDto> teamDetailsDtoList = objectMapper.convertValue(teamDetailsList,
                new TypeReference<List<TeamDetailsDto>>() {
                });
        log.info("Total {} teams found", teamDetailsDtoList.size());
        return teamDetailsDtoList;
    }

    @Override
    public List<TeamDetailsDto> addTeams(List<TeamDetailsDto> teamDetailsDtoList) {

        List<TeamDetails> teamDetailsList = objectMapper.convertValue(teamDetailsDtoList,
                new TypeReference<List<TeamDetails>>() {
                });
        List<TeamDetails> savedTeamDetailsList = teamDetailsRepo.saveAll(teamDetailsList);

        List<TeamDetailsDto> savedTeamDetailsDtoList = objectMapper.convertValue(savedTeamDetailsList,
                new TypeReference<List<TeamDetailsDto>>() {
                });
        log.info("Total {} teams added successfully", savedTeamDetailsDtoList.size());
        return savedTeamDetailsDtoList;
    }
}
