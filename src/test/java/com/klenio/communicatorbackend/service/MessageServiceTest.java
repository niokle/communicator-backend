package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.domain.Team;
import com.klenio.communicatorbackend.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Test
    public void getAllMessages() {
        //given
        User user = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long userId = user.getId();
        Team team = teamService.saveTeam(new Team(1L, user, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Message message1 = messageService.saveMessage(new Message(1L, LocalDateTime.now(), user, user, team, "message1", new ArrayList<>(),
                new ArrayList<>(), true, new ArrayList<>()));
        Message message2 = messageService.saveMessage(new Message(2L, LocalDateTime.now(), user, user, team, "message2", new ArrayList<>(),
                new ArrayList<>(), true, new ArrayList<>()));
        //when
        int records = messageService.getAllMessages().size();

        //then
        Assert.assertTrue(records > 1);

        //clean up
        userService.deleteUser(userId);
    }

    @Test
    public void getMessage() {
        //given
        User user = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long userId = user.getId();
        Team team = teamService.saveTeam(new Team(1L, user, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Message message = messageService.saveMessage(new Message(1L, LocalDateTime.now(), user, user, team, "message1", new ArrayList<>(),
                new ArrayList<>(), true, new ArrayList<>()));
        Long messageId = message.getId();
        //when
        String messageText = messageService.getMessage(messageId).get().getMessage();

        //then
        Assert.assertEquals("message1", messageText);

        //clean up
        userService.deleteUser(userId);
    }

    @Test
    public void saveMessage() {
        //given
        User user = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long userId = user.getId();
        Team team = teamService.saveTeam(new Team(1L, user, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Message message = messageService.saveMessage(new Message(1L, LocalDateTime.now(), user, user, team, "message1", new ArrayList<>(),
                new ArrayList<>(), true, new ArrayList<>()));
        Long messageId = message.getId();
        //when
        String messageText = messageService.getMessage(messageId).get().getMessage();

        //then
        Assert.assertEquals("message1", messageText);

        //clean up
        userService.deleteUser(userId);
    }

    @Test
    public void deleteMessage() {
        //given
        User user = userService.saveUser(new User(1L, "user1", "user1@", "12345",
                "Warszawa", "Polish", "on-line", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>()));
        Long userId = user.getId();
        Team team = teamService.saveTeam(new Team(1L, user, "team1", new ArrayList<>(), true,
                true, new ArrayList<>()));
        Message message = messageService.saveMessage(new Message(1L, LocalDateTime.now(), user, user, team, "message1", new ArrayList<>(),
                new ArrayList<>(), true, new ArrayList<>()));
        Long messageId = message.getId();
        //when
        messageService.deleteMessage(messageId);

        //then
        Assert.assertFalse(messageService.getMessage(messageId).equals(true));

        //clean up
        userService.deleteUser(userId);
    }
}