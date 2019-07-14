package com.klenio.communicatorbackend.mapper;

import com.klenio.communicatorbackend.domain.Message;
import com.klenio.communicatorbackend.domain.User;
import com.klenio.communicatorbackend.dto.MessageDto;
import com.klenio.communicatorbackend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MessageMapper {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeamMapper teamMapper;

    public MessageDto messageToMessageDto(Message message) {
        List<UserDto> deliveredTo = Optional.ofNullable(message.getDeliveredTo())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());
        List<UserDto> readedBy = Optional.ofNullable(message.getReadedBy())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());
        List<UserDto> readConfirmedBy = Optional.ofNullable(message.getReadConfirmedBy())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(user -> userMapper.userToUserDto(user))
                .collect(Collectors.toList());

        return new MessageDto(message.getId(), message.getTimeStamp(), userMapper.userToUserDto(message.getSenderUser()),
                userMapper.userToUserDto(message.getReceiverUser()), teamMapper.teamToTeamDto(message.getReceiverTeam()),
                message.getMessage(), deliveredTo, readedBy, message.isReadConfirmationSent(),
                readConfirmedBy);
    }

    public Message messageDtoToMessage(MessageDto messageDto) {
        List<User> deliveredTo = Optional.ofNullable(messageDto.getDeliveredTo())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(userDto -> userMapper.userDtoToUser(userDto))
                .collect(Collectors.toList());
        List<User> readedBy = Optional.ofNullable(messageDto.getReadedBy())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(userDto -> userMapper.userDtoToUser(userDto))
                .collect(Collectors.toList());
        List<User> readConfirmedBy = Optional.ofNullable(messageDto.getReadConfirmedBy())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(userDto -> userMapper.userDtoToUser(userDto))
                .collect(Collectors.toList());

        return new Message(messageDto.getId(), messageDto.getTimeStamp(), userMapper.userDtoToUser(messageDto.getSenderUserDto()),
                userMapper.userDtoToUser(messageDto.getReceiverUserDto()), teamMapper.teamDtoToTeam(messageDto.getReceiverTeamDto()),
                messageDto.getMessage(), deliveredTo, readedBy, messageDto.isReadConfirmationSent(), readConfirmedBy);
    }
}
