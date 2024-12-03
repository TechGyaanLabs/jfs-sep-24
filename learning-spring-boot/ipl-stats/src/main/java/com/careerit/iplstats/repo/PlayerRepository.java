package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    @Query("select p from Player p where p.name ilike %:searchTerm% or p.country ilike %:searchTerm% or p.team ilike %:searchTerm%")
    Page<Player> search(@Param("searchTerm") String searchTerm, Pageable pageable);
}
