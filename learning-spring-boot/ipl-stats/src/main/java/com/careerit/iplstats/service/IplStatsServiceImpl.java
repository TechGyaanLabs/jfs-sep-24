package com.careerit.iplstats.service;

import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.repo.IplStatsRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatsRepo iplStatsRepo;

    @Override
    public TeamNames getTeamNames() {
         Set<String> teamName = iplStatsRepo.getTeamNames();
         log.info("Total {} teams found",teamName.size());
         return new TeamNames(teamName);
    }
}
