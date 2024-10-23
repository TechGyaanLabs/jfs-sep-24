package com.careerit.iplstats.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto implements Comparable<PlayerDto> {

    private String name;
    private String role;
    private double price;
    private String teamName;
    private String teamLabel;

    @Override
    public int compareTo(PlayerDto o) {
        return Double.compare(o.price, this.price);
    }
}
