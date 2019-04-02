package com.divij.chatapplication.mapper;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.entity.User;

@Component
public class MessageMapper {
	
	public Message mapDtoToEntity(final ReceivedMessageDto messageDto, final Message message) {
		
		message.setMessageContent(messageDto.getMessage());
		message.setMessageTimestamp(new Timestamp((new Date()).getTime()));
//		message.setReceiver(new User(messageDto.getFriendId()));
//		message.setSender(new User("Divij"));
		
		return message;
	}

}
