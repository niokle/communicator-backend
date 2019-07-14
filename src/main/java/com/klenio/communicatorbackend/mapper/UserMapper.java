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
public class UserMapper {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private MessageMapper messageMapper;

    public UserDto userToUserDto(User user) {
        List<TeamDto> teamDtos = Optional.ofNullable(user.getTeams())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(team -> teamMapper.teamToTeamDto(team))
                .collect(Collectors.toList());
        List<MessageDto> messageDtosSender = Optional.ofNullable(user.getMessagesSender())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(message -> messageMapper.messageToMessageDto(message))
                .collect(Collectors.toList());
        List<MessageDto> messageDtosReceiver = Optional.ofNullable(user.getMessagesReceiver())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(message -> messageMapper.messageToMessageDto(message))
                .collect(Collectors.toList());

        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getLocation(),
                user.getLanguage(), user.getStatus(), user.isActive(), teamDtos, messageDtosSender, messageDtosReceiver);
    }

    public User userDtoToUser(UserDto userDto) {
        List<Team> teams = Optional.ofNullable(userDto.getTeamsDtos())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(teamDto -> teamMapper.teamDtoToTeam(teamDto))
                .collect(Collectors.toList());
        List<Message> messagesSender = Optional.ofNullable(userDto.getMessagesDtosSender())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(messageDto -> messageMapper.messageDtoToMessage(messageDto))
                .collect(Collectors.toList());
        List<Message> messagesReceiver = Optional.ofNullable(userDto.getMessagesDtosReceiver())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(messageDto -> messageMapper.messageDtoToMessage(messageDto))
                .collect(Collectors.toList());

        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPassword(),
                userDto.getLocation(), userDto.getLanguage(), userDto.getStatus(), userDto.isActive(), teams,
                messagesSender, messagesReceiver);
    }

    public List<UserDto> usersToUsersDtos(List<User> users) {
        return users.stream()
                .map(user -> userToUserDto(user))
                .collect(Collectors.toList());
    }
}
