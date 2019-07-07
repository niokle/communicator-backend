package com.klenio.communicatorbackend.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private Long id;
    private LocalDateTime timeStamp;
    private Long senderUserId;
    private Long receiverUserId;
    private Long receiverGroupId;
    private String message;
    private List<User> deliveredTo;
    private List<User> readedBy;
    private boolean readConfirmationSent;
    private List<User> readConfirmedBy;
}
