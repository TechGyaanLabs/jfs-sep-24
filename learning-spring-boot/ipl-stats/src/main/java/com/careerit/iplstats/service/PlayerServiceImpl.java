package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.repo.PlayerRepository;
import com.careerit.iplstats.util.ObjectConvertor;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final ObjectConvertor objectConvertor;
    private final PlayerRepository playerRepository;

    @Override
    public PlayerDto addPlayer(PlayerDto playerDto) {
        validatePlayer(playerDto);
        Player player = objectConvertor.toDomain(playerDto, Player.class);
        player = playerRepository.save(player);
        playerDto = objectConvertor.toDto(player, PlayerDto.class);
        log.info("Player with id : {} is added", playerDto.getId());
        return playerDto;
    }

    @Override
    public List<PlayerDto> addPlayers(List<PlayerDto> playerDtos) {
        Assert.notEmpty(playerDtos, "PlayerDtos can't be empty or null");
        log.info("Total {} players are going to be added", playerDtos.size());
        List<Player> players = objectConvertor.toDomain(playerDtos, new TypeReference<List<Player>>() {});
        players = playerRepository.saveAll(players);
        List<PlayerDto> playerDtoList = objectConvertor.toDto(players, new TypeReference<List<PlayerDto>>() {});
        log.info("Total {} players are added", playerDtoList.size());
        return playerDtoList;
    }

    @Override
    public Page<PlayerDto> findPlayers(Pageable pageable) {
        Page<Player> playerPage = playerRepository.findAll(pageable);
        return playerPage.map(player -> objectConvertor.toDto(player, PlayerDto.class));

    }

    private static void validatePlayer(PlayerDto playerDto) {
        Assert.notNull(playerDto, "PlayerDto can't be null");
        Assert.hasText(playerDto.getName(), "Name can't be empty or null");
        Assert.notNull(playerDto.getRole(), "Role can't be null");
        Assert.hasText(playerDto.getCountry(), "Country can't be empty or null");
        Assert.hasText(playerDto.getTeam(), "Team can't be empty or null");
        Assert.isTrue(playerDto.getPrice() > 0, "Amount should be greater than 0");
    }


}
