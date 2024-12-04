package com.careerit.iplstats.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class TeamDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "team")
    private String team;
    @Column(name = "name")
    private String name;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "total_players")
    private long totalPlayers;
    @Column(name = "remaining_amount")
    private double remainingAmount;

}
