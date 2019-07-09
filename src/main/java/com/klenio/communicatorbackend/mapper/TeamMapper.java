package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.TeamDto;
import com.klenio.communicatorbackend.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {
    UserMapper userMapper;

    public TeamDto groupToGroupDto(Team team) {
        List<UserDto> userDtos = new ArrayList<>();
        team.getUsers().stream()
                .forEach(user -> userDtos.add(userMapper.userToUserDto(user)));

        return new TeamDto(team.getId(), team.getOwnerId(), team.getName(),
                userDtos, team.isMain(), team.isActive());
    }

    public Team groupDtoToGroup(TeamDto teamDto) {
        List<User> users = new ArrayList<>();
        teamDto.getUserDtos().stream()
                .forEach(userDto -> users.add(userMapper.userDtoToUser(userDto)));

        return new Team(teamDto.getId(), teamDto.getOwnerId(), teamDto.getName(),
                users, teamDto.isMain(), teamDto.isActive());
    }
}
