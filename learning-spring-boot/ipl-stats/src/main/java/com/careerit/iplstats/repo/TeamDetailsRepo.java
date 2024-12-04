package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, UUID> {

    @Query("select t from TeamDetails t where t.team = :team")
    Optional<TeamDetails> findByTeam(@Param("team") String team);
}
