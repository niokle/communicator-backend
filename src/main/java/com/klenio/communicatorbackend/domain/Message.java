package com.klenio.communicatorbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeStamp;
    private Long senderUserId;
    private Long receiverUserId;
    private Long receiverTeamId;
    private String message;
    @ElementCollection
    private List<User> deliveredTo;
    @ElementCollection
    private List<User> readedBy;
    private boolean readConfirmationSent;
    @ElementCollection
    private List<User> readConfirmedBy;
}
