package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.UserDto;
import com.klenio.communicatorbackend.exception.UserNotFoundException;
import com.klenio.communicatorbackend.mapper.UserMapper;
import com.klenio.communicatorbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userMapper.usersToUsersDtos(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        return userMapper.userToUserDto(userService.getUser(id).orElseThrow(UserNotFoundException::new));
    }

    @PutMapping("/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userService.saveUser(userMapper.userDtoToUser(userDto)));
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userService.saveUser(userMapper.userDtoToUser(userDto)));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
