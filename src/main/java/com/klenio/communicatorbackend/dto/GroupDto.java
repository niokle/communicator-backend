package com.klenio.communicatorbackend.dto;

import java.util.List;

public class GroupDto {
    private Long id;
    private Long ownerId;
    private String name;
    private List<UserDto> usersDtos;
    private boolean main;
    private boolean active;
}
