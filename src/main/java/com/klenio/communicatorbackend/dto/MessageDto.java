package com.klenio.communicatorbackend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MessageDto {
    private Long id;
    private LocalDateTime timeStamp;
    private Long senderUserId;
    private Long receiverUserId;
    private Long receiverGroupId;
    private String message;
    private List<UserDto> deliveredTo;
    private List<UserDto> readedBy;
    private boolean readConfirmationSent;
    private List<UserDto> readConfirmedBy;
}
