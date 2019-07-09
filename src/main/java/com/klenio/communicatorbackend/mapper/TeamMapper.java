package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.TeamDto;
import com.klenio.communicatorbackend.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {
    UserMapper userMapper;

    public TeamDto teamToTeamDto(Team team) {
        List<UserDto> userDtos = new ArrayList<>();
        team.getTeamUsers().stream()
                .forEach(user -> userDtos.add(userMapper.userToUserDto(user)));

        return new TeamDto(team.getId(), team.getOwnerId(), team.getName(),
                userDtos, team.isMain(), team.isActive());
    }

    public Team teamDtoToTeam(TeamDto teamDto) {
        List<User> users = new ArrayList<>();
        teamDto.getTeamUserDtos().stream()
                .forEach(userDto -> users.add(userMapper.userDtoToUser(userDto)));

        return new Team(teamDto.getId(), teamDto.getOwnerId(), teamDto.getName(),
                users, teamDto.isMain(), teamDto.isActive());
    }
}
