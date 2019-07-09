package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.MessageDto;
import com.klenio.communicatorbackend.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class MessageMapper {
    UserMapper userMapper;

    public MessageDto messageToMessageDto(Message message) {
        List<UserDto> deliveredTo = new ArrayList<>();
        List<UserDto> readedBy = new ArrayList<>();
        List<UserDto> readConfirmedBy = new ArrayList<>();

        message.getDeliveredTo().stream()
                .forEach(user -> deliveredTo.add(userMapper.userToUserDto(user)));

        message.getReadedBy().stream()
                .forEach(user -> readedBy.add(userMapper.userToUserDto(user)));

        message.getReadConfirmedBy().stream()
                .forEach(user -> readConfirmedBy.add(userMapper.userToUserDto(user)));

        return new MessageDto(message.getId(), message.getTimeStamp(), message.getSenderUserId(),
                message.getReceiverUserId(), message.getReceiverTeamId(), message.getMessage(),
                deliveredTo, readedBy, message.isReadConfirmationSent(),
                readConfirmedBy);
    }

    public Message messageDtoToMessage(MessageDto messageDto) {
        List<User> deliveredTo = new ArrayList<>();
        List<User> readedBy = new ArrayList<>();
        List<User> readConfirmedBy = new ArrayList<>();

        messageDto.getDeliveredTo().stream()
                .forEach(userDto -> deliveredTo.add(userMapper.userDtoToUser(userDto)));

        messageDto.getReadedBy().stream()
                .forEach(userDto -> readedBy.add(userMapper.userDtoToUser(userDto)));

        messageDto.getReadConfirmedBy().stream()
                .forEach(userDto -> readConfirmedBy.add(userMapper.userDtoToUser(userDto)));

        return new Message(messageDto.getId(), messageDto.getTimeStamp(), messageDto.getSenderUserId(),
                messageDto.getReceiverUserId(), messageDto.getReceiverTeamId(), messageDto.getMessage(),
                deliveredTo, readedBy, messageDto.isReadConfirmationSent(),
                readConfirmedBy);
    }
}
