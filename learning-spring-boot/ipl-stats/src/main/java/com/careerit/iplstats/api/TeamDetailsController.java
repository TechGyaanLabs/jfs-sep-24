package com.careerit.iplstats.api;

import com.careerit.iplstats.dto.TeamDetailsDto;
import com.careerit.iplstats.service.TeamDetailsService;
import com.careerit.iplstats.util.ApiResponse;
import com.careerit.iplstats.util.ListApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ipl/team")
@RequiredArgsConstructor
public class TeamDetailsController {

    private final TeamDetailsService teamDetailsService;

    @PostMapping
    public ApiResponse<TeamDetailsDto> addTeam(@RequestBody TeamDetailsDto teamDetailsDto){
        TeamDetailsDto addedTeamDetails = teamDetailsService.addTeam(teamDetailsDto);
        return ApiResponse.success(addedTeamDetails);
    }

    @GetMapping("/all")
    public ListApiResponse<TeamDetailsDto> getTeamDetails(){
        List<TeamDetailsDto> teamDetails = teamDetailsService.getTeamDetails();
        return ListApiResponse.success(teamDetails,teamDetails.size());
    }

    @PostMapping("/bulk")
    public ListApiResponse<TeamDetailsDto> addTeams(@RequestBody List<TeamDetailsDto> teamDetailsDtoList){
        List<TeamDetailsDto> addedTeams = teamDetailsService.addTeams(teamDetailsDtoList);
        return ListApiResponse.success(addedTeams,addedTeams.size());
    }

}
