package com.divij.chatapplication.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
/*
 * Not yet implemented.
 */
class MessageMapperTest {

@Autowired
private MessageMapper messageMapper;


	
	@Test
	void testMapDtoToEntity() {
	Message message = new Message();
	
	ReceivedMessageDto receivedMessage = new ReceivedMessageDto();
		
	assertEquals(message, messageMapper.mapDtoToEntity(receivedMessage, message));
		
	}

	@Test
	void testMapEntityToDto() {
	
	
	}

}
