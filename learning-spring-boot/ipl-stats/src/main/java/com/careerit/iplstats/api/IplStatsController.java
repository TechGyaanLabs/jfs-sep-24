package com.careerit.iplstats.api;


import com.careerit.iplstats.records.TeamNames;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/ipl/stats")
@RequiredArgsConstructor
public class IplStatsController {


        private final IplStatsService iplStatsService;

        @GetMapping("/team-names")
        public ApiResponse<TeamNames> getTeamNames(){
            return ApiResponse.success(iplStatsService.getTeamNames());
        }

}
