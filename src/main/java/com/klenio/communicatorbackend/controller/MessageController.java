package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.MessageDto;
import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class MessageController {

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        //todo
        return new ArrayList<>();
    }

    @GetMapping("/messages/{id}")
    public MessageDto getMessage(@PathVariable Long id) {
        //todo
        return null;
    }

    @PutMapping("/messages")
    public MessageDto updateMessage(@RequestBody MessageDto messageDto) {
        //todo tylko jak nie przeczytana przez zadnego z odbiorcow
        return null;
    }

    @PostMapping("/messages")
    public MessageDto createMessage(@RequestBody MessageDto messageDto) {
        //todo
        return null;
    }

    @DeleteMapping("/messages/{id}")
    public boolean deleteMessage(@PathVariable Long id) {
        //todo tylko jak nie przeczytana przez zadnego z odbiorcow
        return true;
    }
}
