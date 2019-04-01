package com.divij.chatapplication.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE_DTL")
public class Message {

	@Id
	@Column(name="MESSAGE_ID")
	private int messageId;
	
	@Column(name="SENDER")
	private User sender;
	
	@Column(name="RECEIVER")
	private User receiver;
	
	@Column(name="MESSAGE_CONTENT")
	private String messageContent;
	
	@Column(name="message_tmstmp")
	private Timestamp messageTimestamp;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Timestamp getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(Timestamp messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	
}
