package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto userToUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getLocation(),
                user.getLanguage(), user.getStatus(), user.isActive());
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPassword(),
                userDto.getLocation(), userDto.getLanguage(), userDto.getStatus(), userDto.isActive());
    }

    public List<UserDto> usersToUsersDtos(List<User> users) {
        return users.stream()
                .map(user -> userToUserDto(user))
                .collect(Collectors.toList());
    }
}
