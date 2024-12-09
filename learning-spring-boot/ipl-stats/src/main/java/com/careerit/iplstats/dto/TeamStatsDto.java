package com.careerit.iplstats.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamStatsDto {

    private List<TopPlayerDto> topPlayers;
    private List<TopPlayerDto> topPaidPlayerOfEachRole;
    private List<PlayerDto> players;

}
