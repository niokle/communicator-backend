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

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTest {
    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @Test
    public void getAllTeams() {
        //given
        User owner = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long ownerId = owner.getId();
        Team team1 = teamService.saveTeam(new Team(1L, owner, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Team team2 = teamService.saveTeam(new Team(2L, owner, "team2", new ArrayList<>(), true,
                true, new ArrayList<>()));

        //when
        int records = teamService.getAllTeams().size();

        //then
        Assert.assertTrue(records > 1);

        //clean up
        userService.deleteUser(ownerId);
    }

    @Test
    public void getTeam() {
        //given
        User owner = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long ownerId = owner.getId();
        Team team1 = teamService.saveTeam(new Team(1L, owner, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Long teamId1 = team1.getId();

        //when
        Optional<Team> teamResult = teamService.getTeam(teamId1);

        //then
        Assert.assertEquals("team1", teamResult.get().getName());

        //clean up
        userService.deleteUser(ownerId);
    }

    @Test
    public void saveTeam() {
        //given
        User owner = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long ownerId = owner.getId();
        Team team1 = teamService.saveTeam(new Team(1L, owner, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Long teamId1 = team1.getId();

        //when
        Optional<Team> teamResult = teamService.getTeam(teamId1);

        //then
        Assert.assertEquals("team1", teamResult.get().getName());

        //clean up
        userService.deleteUser(ownerId);
    }

    @Test
    public void deleteTeam() {
        //given
        User owner = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long ownerId = owner.getId();
        Team team1 = teamService.saveTeam(new Team(1L, owner, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Long teamId1 = team1.getId();

        //when
        teamService.deleteTeam(teamId1);

        //then
        Assert.assertFalse(teamService.getTeam(teamId1).equals(true));

        //clean up
        userService.deleteUser(ownerId);
    }
}