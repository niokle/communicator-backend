package com.klenio.communicatorbackend.service;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
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

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    public boolean isRead(Long id) {
        if (messageRepository.findById(id).get().getReadedBy().size() == 0) {
            return false;
        }
        return true;
    }
}
