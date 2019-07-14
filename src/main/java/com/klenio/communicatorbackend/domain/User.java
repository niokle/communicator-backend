package com.klenio.communicatorbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String location;
    private String language;
    private String status;
    private boolean active;
    @OneToMany(targetEntity = Team.class, mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Team> teams = new ArrayList<>();
    @OneToMany(targetEntity = Message.class, mappedBy = "senderUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messagesSender = new ArrayList<>();
    @ManyToMany(targetEntity = Message.class, mappedBy = "receiverUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messagesReceiver = new ArrayList<>();
}
