package com.careerit.iplstats.api;


import com.careerit.iplstats.dto.*;
import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ipl/stats")
@RequiredArgsConstructor
public class IplStatsController {


        private final IplStatsService iplStatsService;

        @GetMapping("/team-names")
        public ApiResponse<TeamNames> getTeamNames(){
            return ApiResponse.success(iplStatsService.getTeamNames());
        }

        @GetMapping("/team-amount")
        public ApiResponse<List<TeamWithAmountDto>> getTeamAmount(){
            return ApiResponse.success(iplStatsService.getTeamWithAmount());
        }

        @GetMapping("/player-count-by-country")
        public ApiResponse<List<CountryWithPlayerCountDto>> getPlayerCountByCountry(){
            return ApiResponse.success(iplStatsService.getPlayerCountByCountry());
        }

        @GetMapping("/top-paid-players")
        public ApiResponse<List<TopPlayerDto>> getTopPlayers(){
            return ApiResponse.success(iplStatsService.getTopPlayers());
        }

        @GetMapping("/role-count")
        public ApiResponse<List<RoleCountDto>> getRoleCount(){
            return new ApiResponse<List<RoleCountDto>>(iplStatsService.getRoleCount());
        }

        @GetMapping("/team-stats/{team}")
        public ApiResponse<TeamStatsDto> getTeamStats(@PathVariable("team") String team){
            return ApiResponse.success(iplStatsService.getTeamStats(team));
        }

        @GetMapping("/export-players/{team}")
        public ResponseEntity<byte[]> exportPlayers(@PathVariable("team") String team){
            File file = iplStatsService.exportPlayers(team);
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] excelBytes = fileInputStream.readAllBytes();
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .contentLength(excelBytes.length)
                        .body(excelBytes);
            } catch (Exception e) {
                throw new RuntimeException("Error while exporting file", e);
            }
        }


}
