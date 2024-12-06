package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.TeamWithAmountDto;
import com.careerit.iplstats.records.TeamNames;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IplStatDaoImpl implements IplStatDao {

    private final PlayerRepository playerRepository;
    private final TeamDetailsRepo teamDetailsRepo;

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
}
