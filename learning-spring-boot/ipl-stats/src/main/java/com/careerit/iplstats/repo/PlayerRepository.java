package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.CountryWithPlayerCountDto;
import com.careerit.iplstats.dto.RoleCountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    @Query("select p from Player p where p.name ilike %:searchTerm% or p.country ilike %:searchTerm% or p.team ilike %:searchTerm%")
    Page<Player> search(@Param("searchTerm") String searchTerm, Pageable pageable);


    @Query("select new com.careerit.iplstats.dto.CountryWithPlayerCountDto(p.country, count(p)) from Player p group by p.country order by (count(p)) desc")
    List<CountryWithPlayerCountDto> findCountryWithPlayerCount();

    @Query(value = "select id,name,role,country,team,price from( " +
            " select id,name,role,country,team,price,dense_rank() over(partition by team order by price desc)" +
            " as rnk from player_details pd where pd.team=:team) temp where temp.rnk = 1;",nativeQuery = true)
    List<Object[]> findTopPlayersOfTeam(@Param("team") String team);


    @Query(value = "select id,name,role,country,team,price from( " +
            " select id,name,role,country,team,price,dense_rank() over(partition by team,role order by price desc)" +
            " as rnk from player_details pd where pd.team=:team) temp where temp.rnk = 1;",nativeQuery = true)
    List<Object[]> findTopPlayersOfTeamAndEachRole(@Param("team") String team);


    @Query(value = "select id,name,role,country,team,price from( " +
            " select id,name,role,country,team,price,dense_rank() over(partition by team order by price desc)" +
            " as rnk from player_details pd) temp where temp.rnk = 1;",nativeQuery = true)
    List<Object[]> findTopPlayers();

    @Query("select new com.careerit.iplstats.dto.RoleCountDto(p.role, count(p)) from Player p group by p.role order by (count(p)) desc")
    List<RoleCountDto> findRoleCount();

    @Query("select p from Player p where p.team=:team")
    List<Player> findPlayersByTeam(@Param("team") String team);

    List<Player> findByTeam(String team);
}
