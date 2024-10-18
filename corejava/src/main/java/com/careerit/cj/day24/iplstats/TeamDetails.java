package com.careerit.cj.day24.iplstats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDetails {

        private String name;
        private String city;
        private String label;

        private List<PlayerDetails> players;
}
