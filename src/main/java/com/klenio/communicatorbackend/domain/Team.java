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
@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User owner;
    private String name;
    @ElementCollection
    private List<User> teamUsers;
    private boolean main;
    private boolean active;
    @OneToMany(targetEntity = Message.class, mappedBy = "receiverTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messagesReceiver = new ArrayList<>();
}
