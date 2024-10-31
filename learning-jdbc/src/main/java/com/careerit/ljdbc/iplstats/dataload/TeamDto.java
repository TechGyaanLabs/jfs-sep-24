package com.careerit.ljdbc.iplstats.dataload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDto {

        private String name;
        private String label;
        private String home;
        private String coach;
        private String city;
        private List<PlayerDto> players;
}
