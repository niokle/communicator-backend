package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.TeamDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class TeamController {

    @GetMapping("/teams")
    public List<TeamDto> getTeams() {
        //todo
        return new ArrayList<>();
    }

    @GetMapping("/teams/{id}")
    public TeamDto getTeam(@PathVariable Long id) {
        //todo
        return null;
    }

    @PutMapping("/teams")
    public TeamDto updateTeam(@RequestBody TeamDto teamDto) {
        //todo
        return null;
    }

    @PostMapping("/teams")
    public TeamDto createTeam(@RequestBody TeamDto teamDto) {
        //todo
        return null;
    }

    @DeleteMapping("/groups/{id}")
    public boolean deleteTeam(@PathVariable Long id) {
        //todo
        return true;
    }
}
