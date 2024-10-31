package com.careerit.ljdbc.iplstats.service;

import java.util.List;

public interface IplStatsService {

        List<TeamAmount> getTeamTotalAmounts();
        List<MaxAmount> getMaxAmountsOfEachTeam();
        List<PlayerBasicDetails> getBasicPlayerDetailsOfAllTeams();
        List<PlayerBasicDetails> getTopNAmountPaidPlayersOfEachTeam(int n);
}
