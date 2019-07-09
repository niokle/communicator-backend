package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers() {
        //given
        User user1 = new User(1L, "user1", "user1@", "12345", "Warszawa", "Polish", "on-line", true);
        User user2 = new User(2L, "user2", "user2@", "12345", "Warszawa", "Polish", "on-line", true);
        Long userId1 = userService.saveUser(user1).getId();
        Long userId2 = userService.saveUser(user2).getId();

        //when
        int records = userService.getAllUsers().size();

        //then
        Assert.assertTrue(records > 1);

        //clean up
        userService.deleteUser(userId1);
        userService.deleteUser(userId2);
    }

    @Test
    public void getUser() {
        //given
        User user1 = new User(1L, "user1", "user1@", "12345", "Warszawa", "Polish", "on-line", true);
        Long userId1 = userService.saveUser(user1).getId();

        //when
        Optional<User> userResult = userService.getUser(userId1);

        //then
        Assert.assertEquals("user1@", userResult.get().getEmail());

        //clean up
        userService.deleteUser(userId1);
    }

    @Test
    public void saveUser() {
        //given
        User user1 = new User(1L, "user1", "user1@", "12345", "Warszawa", "Polish", "on-line", true);
        Long userId1 = userService.saveUser(user1).getId();

        //when
        Optional<User> userResult = userService.getUser(userId1);

        //then
        Assert.assertEquals("user1@", userResult.get().getEmail());

        //clean up
        userService.deleteUser(userId1);
    }

    @Test
    public void deleteUser() {
        //given
        User user1 = new User(1L, "user1", "user1@", "12345", "Warszawa", "Polish", "on-line", true);
        Long userId1 = userService.saveUser(user1).getId();

        //when
        userService.deleteUser(userId1);

        //then
        Assert.assertFalse(userService.getUser(userId1).equals(true));

        //clean up
    }
}