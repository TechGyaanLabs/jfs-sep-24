package com.careerit.iplstats.service;

import com.careerit.iplstats.repo.IplStatsRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Getter
@Setter
public class IplStatsServiceImpl implements IplStatsService {


    private final IplStatsRepo iplStatsRepo;

    @Override
    public Set<String> getTeamNames() {
        return iplStatsRepo.getTeamNames();
    }
}
