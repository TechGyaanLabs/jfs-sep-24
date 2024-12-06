package com.careerit.iplstats.repo;


import com.careerit.iplstats.dto.TeamWithAmountDto;
import com.careerit.iplstats.records.TeamNames;

import java.util.List;

public interface IplStatDao {

    TeamNames getTeamNames();
    List<TeamWithAmountDto> getTeamWithAmount();



}
