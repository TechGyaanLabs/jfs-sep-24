package com.careerit.cj.day24.iplstats;

import java.util.List;

public interface IplStatService {

        List<String> teamLabels();
        List<PlayerDetails> players(String teamLabel);
        List<TeamAmountDto> teamAmounts();
}
