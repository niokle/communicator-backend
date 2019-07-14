package com.klenio.communicatorbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDto {
    private Long id;
    private LocalDateTime timeStamp;
    private UserDto senderUserDto;
    private UserDto receiverUserDto;
    private TeamDto receiverTeamDto;
    private String message;
    private List<UserDto> deliveredTo; //todo
    private List<UserDto> readedBy; //todo
    private boolean readConfirmationSent;
    private List<UserDto> readConfirmedBy; //todo
}
