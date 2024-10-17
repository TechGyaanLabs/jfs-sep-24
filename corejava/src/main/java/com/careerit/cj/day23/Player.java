package com.careerit.cj.day23;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

        private String name;
        private String role;
        private String country;
        private double amount;

        @JsonProperty("team_label")
        private String teamName;

        private String team;
}
