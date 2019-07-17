package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private MessageMapper messageMapper;

    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getLocation(),
                user.getLanguage(), user.getStatus(), user.isActive(), teamMapper.teamsToTeamsDtos(user.getTeams()),
                messageMapper.messagesToMessagesDtos(user.getMessagesSender()),
                messageMapper.messagesToMessagesDtos(user.getMessagesReceiver()));
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPassword(),
                userDto.getLocation(), userDto.getLanguage(), userDto.getStatus(), userDto.isActive(),
                teamMapper.teamsDtosToTeams(userDto.getTeamsDtos()),
                messageMapper.messagesDtosToMessages(userDto.getMessagesDtosSender()),
                messageMapper.messagesDtosToMessages(userDto.getMessagesDtosReceiver()));
    }

    public List<UserDto> usersToUsersDtos(List<User> users) {
        return users.stream()
                .map(user -> userToUserDto(user))
                .collect(Collectors.toList());
    }

    public List<User> usersDtosToUsers(List<UserDto> usersDtos) {
        return usersDtos.stream()
                .map(userDto -> userDtoToUser(userDto))
                .collect(Collectors.toList());
    }
}
