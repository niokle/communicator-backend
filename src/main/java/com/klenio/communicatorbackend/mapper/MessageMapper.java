package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageMapper {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeamMapper teamMapper;

    public MessageDto messageToMessageDto(Message message) {
        return new MessageDto(message.getId(), message.getTimeStamp(), userMapper.userToUserDto(message.getSenderUser()),
                userMapper.userToUserDto(message.getReceiverUser()), teamMapper.teamToTeamDto(message.getReceiverTeam()),
                message.getMessage(), userMapper.usersToUsersDtos(message.getDeliveredTo()),
                userMapper.usersToUsersDtos(message.getReadedBy()), message.isReadConfirmationSent(),
                userMapper.usersToUsersDtos(message.getReadConfirmedBy()));
    }

    public Message messageDtoToMessage(MessageDto messageDto) {
        return new Message(messageDto.getId(), messageDto.getTimeStamp(), userMapper.userDtoToUser(messageDto.getSenderUserDto()),
                userMapper.userDtoToUser(messageDto.getReceiverUserDto()), teamMapper.teamDtoToTeam(messageDto.getReceiverTeamDto()),
                messageDto.getMessage(), userMapper.usersDtosToUsers(messageDto.getDeliveredTo()),
                userMapper.usersDtosToUsers(messageDto.getReadedBy()),
                messageDto.isReadConfirmationSent(), userMapper.usersDtosToUsers(messageDto.getReadConfirmedBy()));
    }

    public List<MessageDto> messagesToMessagesDtos(List<Message> messages) {
        return messages.stream()
                .map(message -> messageToMessageDto(message))
                .collect(Collectors.toList());
    }

    public List<Message> messagesDtosToMessages(List<MessageDto> messagesDtos) {
        return messagesDtos.stream()
                .map(messageDto -> messageDtoToMessage(messageDto))
                .collect(Collectors.toList());
    }
}
