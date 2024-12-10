package com.careerit.iplstats.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamStatsDto {

    private List<TopPlayerDto> topPlayers;
    private Map<String,List<TopPlayerDto>> topPaidPlayerOfEachRole;
    private List<PlayerDto> players;

}
