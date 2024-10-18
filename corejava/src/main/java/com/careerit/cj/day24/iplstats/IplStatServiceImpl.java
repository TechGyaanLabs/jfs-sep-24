package com.careerit.cj.day24.iplstats;

import com.careerit.cj.day24.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class IplStatServiceImpl implements IplStatService {

        List<TeamDetails> teamDetails = new ArrayList<>();

        public IplStatServiceImpl() {
                teamDetails = JsonUtil.fromJson("ipl2020.json", new TypeReference<List<TeamDetails>>(){});
        }

        @Override
        public List<String> teamLabels() {
             return teamDetails.stream().map(TeamDetails::getLabel).toList();
        }

        @Override
        public List<PlayerDetails> players(String teamLabel) {
                return teamDetails.stream()
                        .filter(e -> e.getLabel().equals(teamLabel))
                        .map(TeamDetails::getPlayers)
                        .findFirst()
                        .orElse(new ArrayList<>());
        }

        @Override
        public List<TeamAmountDto> teamAmounts() {
                return teamDetails.stream()
                        .map(e -> {
                                TeamAmountDto teamAmountDto = new TeamAmountDto();
                                teamAmountDto.setTeamLabel(e.getLabel());
                                double totalAmount = e.getPlayers().stream().mapToDouble(PlayerDetails::getPrice).sum();
                                teamAmountDto.setAmount(totalAmount);
                                return teamAmountDto;
                        }).toList();
        }
}
