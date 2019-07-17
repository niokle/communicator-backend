package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    public TeamDto teamToTeamDto(Team team) {
        return new TeamDto(team.getId(), userMapper.userToUserDto(team.getOwner()), team.getName(),
                userMapper.usersToUsersDtos(team.getTeamUsers()), team.isMain(), team.isActive(),
                messageMapper.messagesToMessagesDtos(team.getMessagesReceiver()));
    }

    public Team teamDtoToTeam(TeamDto teamDto) {
        return new Team(teamDto.getId(), userMapper.userDtoToUser(teamDto.getOwnerDto()), teamDto.getName(),
                userMapper.usersDtosToUsers(teamDto.getTeamUserDtos()), teamDto.isMain(), teamDto.isActive(),
                messageMapper.messagesDtosToMessages(teamDto.getMessagesDtosReceiver()));
    }

    public List<TeamDto> teamsToTeamsDtos(List<Team> teams) {
        return teams.stream()
                .map(team -> teamToTeamDto(team))
                .collect(Collectors.toList());
    }

    public List<Team> teamsDtosToTeams(List<TeamDto> teamsDtos) {
        return teamsDtos.stream()
                .map(teamDto -> teamDtoToTeam(teamDto))
                .collect(Collectors.toList());
    }
}
