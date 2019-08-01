package com.klenio.communicatorbackend.controller;

import com.klenio.communicatorbackend.dto.MessageDto;
import com.klenio.communicatorbackend.exception.MessageNotFoundException;
import com.klenio.communicatorbackend.exception.MessageReadException;
import com.klenio.communicatorbackend.mapper.MessageMapper;
import com.klenio.communicatorbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        return messageMapper.messagesToMessagesDtos(messageService.getAllMessages());
    }

    @GetMapping("/messages/{id}")
    public MessageDto getMessage(@PathVariable Long id) throws MessageNotFoundException {
        return messageMapper.messageToMessageDto(messageService.getMessage(id).orElseThrow(MessageNotFoundException::new));
    }

    @PutMapping("/messages")
    public MessageDto updateMessage(@RequestBody MessageDto messageDto) throws MessageReadException{
        if (messageService.isRead(messageDto.getId())) {
            throw new MessageReadException("can't update read message");
        }
        return messageMapper.messageToMessageDto(messageService.saveMessage(messageMapper.messageDtoToMessage(messageDto)));
    }

    @PostMapping("/messages")
    public MessageDto createMessage(@RequestBody MessageDto messageDto) {
        return messageMapper.messageToMessageDto(messageService.saveMessage(messageMapper.messageDtoToMessage(messageDto)));
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable Long id) throws MessageReadException {
        if (messageService.isRead(id)) {
            throw new MessageReadException("can't delete read message");
        }
        messageService.deleteMessage(id);
    }
}
