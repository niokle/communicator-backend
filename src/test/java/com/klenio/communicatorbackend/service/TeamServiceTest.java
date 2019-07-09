package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTest {
    @Autowired
    private TeamService teamService;

    @Test
    public void getAllTeams() {
        //given
        Team team1 = new Team(1L, 1L, "team1", new ArrayList(), true, true);
        Team team2 = new Team(2L, 2L, "team2", new ArrayList(), true, true);
        Long teamId1 = teamService.saveTeam(team1).getId();
        Long teamId2 = teamService.saveTeam(team2).getId();

        //when
        int records = teamService.getAllTeams().size();

        //then
        Assert.assertTrue(records > 1);

        //clean up
        teamService.deleteTeam(teamId1);
        teamService.deleteTeam(teamId2);
    }

    @Test
    public void getTeam() {
        //given
        Team team1 = new Team(1L, 1L, "team1", new ArrayList(), true, true);
        Long teamId1 = teamService.saveTeam(team1).getId();

        //when
        Optional<Team> teamResult = teamService.getTeam(teamId1);

        //then
        Assert.assertEquals("team1", teamResult.get().getName());

        //clean up
        teamService.deleteTeam(teamId1);
    }

    @Test
    public void saveTeam() {
        //given
        Team team1 = new Team(1L, 1L, "team1", new ArrayList(), true, true);
        Long teamId1 = teamService.saveTeam(team1).getId();

        //when
        Optional<Team> teamResult = teamService.getTeam(teamId1);

        //then
        Assert.assertEquals("team1", teamResult.get().getName());

        //clean up
        teamService.deleteTeam(teamId1);
    }

    @Test
    public void deleteTeam() {
        //given
        Team team1 = new Team(1L, 1L, "team1", new ArrayList(), true, true);
        Long teamId1 = teamService.saveTeam(team1).getId();

        //when
        teamService.deleteTeam(teamId1);

        //then
        Assert.assertFalse(teamService.getTeam(teamId1).equals(true));

        //clean up
    }
}