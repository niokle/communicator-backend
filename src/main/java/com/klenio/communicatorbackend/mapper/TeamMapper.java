package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.TeamDto;
import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TeamMapper {
    @Autowired
    private UserMapper userMapper;

    public TeamDto teamToTeamDto(Team team) {
        List<UserDto> userDtos = Optional.ofNullable(team.getTeamUsers())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());

        return new TeamDto(team.getId(), team.getOwnerId(), team.getName(),
                userDtos, team.isMain(), team.isActive());
    }

    public Team teamDtoToTeam(TeamDto teamDto) {
        List<User> users = Optional.ofNullable(teamDto.getTeamUserDtos())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(userDto -> userMapper.userDtoToUser(userDto))
                .collect(Collectors.toList());

        return new Team(teamDto.getId(), teamDto.getOwnerId(), teamDto.getName(),
                users, teamDto.isMain(), teamDto.isActive());
    }

    public List<TeamDto> teamsToTeamsDtos(List<Team> teams) {
        return teams.stream()
                .map(team -> teamToTeamDto(team))
                .collect(Collectors.toList());
    }
}
