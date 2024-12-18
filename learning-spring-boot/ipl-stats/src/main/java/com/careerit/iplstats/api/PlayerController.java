package com.careerit.iplstats.api;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.service.PlayerService;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ipl/players")
@RequiredArgsConstructor
public class PlayerController {


    private final PlayerService playerService;

    @PostMapping
    public ApiResponse<PlayerDto> addPlayer(@RequestBody PlayerDto playerDto) {
        return ApiResponse.success(playerService.addPlayer(playerDto));
    }

    @PostMapping("/bulk")
    public ApiResponse<List<PlayerDto>> addPlayers(@RequestBody List<PlayerDto> playerDtos) {
        return ApiResponse.success(playerService.addPlayers(playerDtos));
    }

    @GetMapping("/list-page")
    public ApiResponse<Page<PlayerDto>> findPlayers(Pageable pageable,
                                                    @RequestParam(defaultValue = "")String searchTerm){
        return ApiResponse.success(playerService.findPlayers(pageable
                ,searchTerm));
    }

}
