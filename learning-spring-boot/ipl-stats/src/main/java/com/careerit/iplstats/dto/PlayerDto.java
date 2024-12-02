package com.careerit.iplstats.dto;

import com.careerit.iplstats.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PlayerDto {

    private UUID id;
    private String name;
    private Role role;
    private String country;
    private String team;
    private double price;

}
