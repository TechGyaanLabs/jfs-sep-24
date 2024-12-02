package com.careerit.iplstats.api;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.service.PlayerService;
import com.careerit.iplstats.util.ApiResponse;
import com.careerit.iplstats.util.ListApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/iplstats/players")
@RequiredArgsConstructor
public class PlayerController {


    private final PlayerService playerService;

    @PostMapping
    public ApiResponse<PlayerDto> addPlayer(@RequestBody PlayerDto playerDto) {
        return ApiResponse.success(playerService.addPlayer(playerDto));
    }

    @PostMapping("/bulk")
    public ListApiResponse<PlayerDto> addPlayers(@RequestBody List<PlayerDto> playerDtos) {
        return ListApiResponse.success(playerService.addPlayers(playerDtos), playerDtos.size());
    }

    @GetMapping("/list-page")
    public ApiResponse<Page<PlayerDto>> findPlayers(@RequestParam(defaultValue = "1",name = "page") int pageNum, @RequestParam(defaultValue = "10",name = "size") int pageSize){
        return ApiResponse.success(playerService.findPlayers(Pageable.ofSize(pageSize).withPage(pageNum)));
    }

}
