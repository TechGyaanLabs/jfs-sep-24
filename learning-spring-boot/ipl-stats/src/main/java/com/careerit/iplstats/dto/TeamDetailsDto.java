package com.careerit.iplstats.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TeamDetailsDto {
    private UUID id;
    private String team;
    private String name;
    private double totalAmount;
    private long totalPlayers;
    private double remainingAmount;
}