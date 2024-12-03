package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface IplStatsRepo extends JpaRepository<Player, UUID> {

    @Query("select distinct p.team from Player p")
    Set<String> getTeamNames();
}
