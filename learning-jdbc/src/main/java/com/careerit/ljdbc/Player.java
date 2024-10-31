package com.careerit.ljdbc;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private long id;
    private String name;
    private String team;
    private long runs;
    private long wickets;


}
