package com.divij.chatapplication.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.entity.User;

/*
 * Not yet implemented.
 */
class MessageMapperTest {

	@Autowired
	private MessageMapper messageMapper;

	@Test
	@DisplayName("Mapping the entity to dto.")
	void testMapEntityToDto() {

		Message message = new Message();

		message.setMessageContent("Hello!");
		message.setMessageId(0);
		message.setMessageTimestamp(new Timestamp(new Date().getTime()));
		message.setRead(false);
		User receiver = new User();
		receiver.setUserId(1);
		receiver.setUserName("thatUser");
		message.setReceiver(receiver);

		User sender = new User();
		sender.setUserId(2);
		sender.setUserName("thisUser");
		message.setSender(sender);

		ReceivedMessageDto receivedMessage = new ReceivedMessageDto();
//assertEquals() is working fine here.
		final ReceivedMessageDto receivedMessage2 = messageMapper.mapEntityToDto(message, receivedMessage);

		assertEquals("true1", "true");// compiler is not reaching upto here.

		// , "1 is only eqlual to 1");//equals(receivedMessage2.getOperation()));
		/*
		 * assertAll(() -> assertEquals(message.getMessageContent(),
		 * receivedMessage2.getMessage()), () ->
		 * assertEquals(message.getMessageTimestamp(),
		 * receivedMessage2.getMessageTime()), () -> assertEquals("RECEIVEING",
		 * receivedMessage2.getOperation()));
		 */
		// assert

	}
	/*
	 * @Test void exampleTest(){
	 * 
	 * assertEquals("tre", "fal"); }
	 * 
	 */ /*
		 * @Test void testMapEntityToDto() {
		 * 
		 * 
		 * }
		 */
}
