package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class GroupController {

    @GetMapping("/groups")
    public List<GroupDto> getGroups() {
        //todo
        return new ArrayList<>();
    }

    @GetMapping("/groups/{id}")
    public GroupDto getGroup(@PathVariable Long id) {
        //todo
        return null;
    }

    @PutMapping("/groups")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        //todo
        return null;
    }

    @PostMapping("/groups")
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        //todo
        return null;
    }

    @DeleteMapping("/groups/{id}")
    public boolean deleteGroup(@PathVariable Long id) {
        //todo
        return true;
    }
}
