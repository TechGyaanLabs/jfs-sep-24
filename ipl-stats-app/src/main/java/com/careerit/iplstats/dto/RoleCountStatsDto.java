package com.careerit.iplstats.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleCountStatsDto {

    private String role;
    private long count;

}

