package com.divij.chatapplication.dto;

import java.sql.Timestamp;

/*
 *This Data Transaction Object is used to receive messages send by the other user to the logged in user. 
 * 
 */
public class ReceivedMessageDto {

	private String message;
	private Timestamp messageTime;

	public Timestamp getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
