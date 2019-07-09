package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

public class MessageService {
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessage(Long id) {
        return messageRepository.findById(id);
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
