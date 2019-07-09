package com.klenio.communicatorbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDto {
    private Long id;
    private Long ownerId;
    private String name;
    private List<UserDto> teamUserDtos;
    private boolean main;
    private boolean active;
}
