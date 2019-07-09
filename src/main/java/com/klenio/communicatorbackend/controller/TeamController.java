package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.TeamDto;
import com.klenio.communicatorbackend.exception.TeamNotFoundException;
import com.klenio.communicatorbackend.mapper.TeamMapper;
import com.klenio.communicatorbackend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamMapper teamMapper;

    @GetMapping("/teams")
    public List<TeamDto> getTeams() {
        return teamMapper.teamsToTeamsDtos(teamService.getAllTeams());
    }

    @GetMapping("/teams/{id}")
    public TeamDto getTeam(@PathVariable Long id) throws TeamNotFoundException {
        return teamMapper.teamToTeamDto(teamService.getTeam(id).orElseThrow(TeamNotFoundException::new));
    }

    @PutMapping("/teams")
    public TeamDto updateTeam(@RequestBody TeamDto teamDto) {
        return teamMapper.teamToTeamDto(teamService.saveTeam(teamMapper.teamDtoToTeam(teamDto)));
    }

    @PostMapping("/teams")
    public TeamDto createTeam(@RequestBody TeamDto teamDto) {
        return teamMapper.teamToTeamDto(teamService.saveTeam(teamMapper.teamDtoToTeam(teamDto)));
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}
