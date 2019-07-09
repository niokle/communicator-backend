package com.klenio.communicatorbackend.repository;

import com.klenio.communicatorbackend.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Override
    List<Message> findAll();

    @Override
    Optional<Message> findById(Long id);

    @Override
    Message save(Message message);
}
