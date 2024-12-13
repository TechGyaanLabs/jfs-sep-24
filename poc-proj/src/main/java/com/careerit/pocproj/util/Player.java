package com.careerit.pocproj.util;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class Player {
    private UUID id;
    private String name;
    private String role;
    private String country;
    private double price;
    private String team;
}
