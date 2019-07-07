package com.klenio.communicatorbackend.domain;

import java.util.List;

public class Group {
    private Long id;
    private Long ownerId;
    private String name;
    private List<User> users;
    private boolean main;
    private boolean active;
}
