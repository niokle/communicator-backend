package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.MessageDto;
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

    @Autowired
    private MessageMapper messageMapper;

    public TeamDto teamToTeamDto(Team team) {
        List<UserDto> userDtos = Optional.ofNullable(team.getTeamUsers())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());
        List<MessageDto> messageDtos = Optional.ofNullable(team.getMessagesReceiver())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(message -> messageMapper.messageToMessageDto(message))
                .collect(Collectors.toList());

        return new TeamDto(team.getId(), userMapper.userToUserDto(team.getOwner()), team.getName(),
                userDtos, team.isMain(), team.isActive(), messageDtos);
    }

    public Team teamDtoToTeam(TeamDto teamDto) {
        List<User> users = Optional.ofNullable(teamDto.getTeamUserDtos())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(userDto -> userMapper.userDtoToUser(userDto))
                .collect(Collectors.toList());
        List<Message> messages = Optional.ofNullable(teamDto.getMessagesDtosReceiver())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(messageDto -> messageMapper.messageDtoToMessage(messageDto))
                .collect(Collectors.toList());

        return new Team(teamDto.getId(), userMapper.userDtoToUser(teamDto.getOwnerDto()), teamDto.getName(),
                users, teamDto.isMain(), teamDto.isActive(), messages);
    }

    public List<TeamDto> teamsToTeamsDtos(List<Team> teams) {
        return teams.stream()
                .map(team -> teamToTeamDto(team))
                .collect(Collectors.toList());
    }
}
