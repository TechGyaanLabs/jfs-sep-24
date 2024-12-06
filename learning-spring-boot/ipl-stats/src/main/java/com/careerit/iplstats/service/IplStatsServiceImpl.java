package com.careerit.iplstats.service;

import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.repo.IplStatDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatDao iplStatDao;

    @Override
    public TeamNames getTeamNames() {
         TeamNames teamName = iplStatDao.getTeamNames();
         log.info("Total {} teams found",teamName.teamNames().size());
         return teamName;
    }
}
