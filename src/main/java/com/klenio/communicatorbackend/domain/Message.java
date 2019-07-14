package com.klenio.communicatorbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @ManyToOne(targetEntity = User.class)
    private User senderUser;
    @ManyToOne(targetEntity = User.class)
    private User receiverUser;
    @ManyToOne(targetEntity = Team.class)
    private Team receiverTeam;
    private String message;
    @ElementCollection
    private List<User> deliveredTo;
    @ElementCollection
    private List<User> readedBy;
    private boolean readConfirmationSent;
    @ElementCollection
    private List<User> readConfirmedBy;
}
