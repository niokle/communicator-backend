package com.klenio.communicatorbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String location;
    private String language;
    private String status;
    private boolean active;
    private List<TeamDto> teamsDtos = new ArrayList<>();
    private List<MessageDto> messagesDtosSender = new ArrayList<>();
    private List<MessageDto> messagesDtosReceiver = new ArrayList<>();
}
