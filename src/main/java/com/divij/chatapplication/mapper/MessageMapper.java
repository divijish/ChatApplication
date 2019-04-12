package com.divij.chatapplication.mapper;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;

@Component
public class MessageMapper {

	/*
	 * Mapping Dto to entity. Here the received dto contains values which are mapped to empty entity.
	 */
	public Message mapDtoToEntity(final ReceivedMessageDto messageDto, final Message message) {

		message.setMessageContent(messageDto.getMessage());

		message.setMessageTimestamp(new Timestamp((new Date()).getTime()));

		return message;
	}

	/*
	 * Mapping Entity to Dto. Here the received entity contains values which are mapped to empty dto.
	 */
	public ReceivedMessageDto mapEntityToDto(final Message message, final ReceivedMessageDto receivedMessage) {

		receivedMessage.setMessage(message.getMessageContent());

		receivedMessage.setMessageTime(message.getMessageTimestamp());
		
		receivedMessage.setOperation("RECEIVING");

		return receivedMessage;
	}

}
