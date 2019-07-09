package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

public class TeamService {
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeam(Long id) {
        return teamRepository.findById(id);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
