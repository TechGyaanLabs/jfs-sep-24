package com.careerit.iplstats.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDetails {
    private String label;
    private String city;
    private String coach;
    private String home;
    private String name;
    private List<Player> players;
}
