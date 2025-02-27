package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerService {
        PlayerDto addPlayer(PlayerDto playerDto);
        List<PlayerDto> addPlayers(List<PlayerDto> playerDtos);
        Page<PlayerDto> findPlayers(Pageable pageable,String searchTerm);
        List<Player> findPlayersByTeam(String team);
        List<Player> findAllPlayers();

}
