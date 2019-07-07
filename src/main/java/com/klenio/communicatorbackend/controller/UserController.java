package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        //todo
        return new ArrayList<>();
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) {
        //todo
        return null;
    }

    @PutMapping("/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        //todo
        return null;
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        //todo
        return null;
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        //todo
        return true;
    }
}
