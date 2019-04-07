package com.divij.chatapplication.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.Message;

@Repository
public interface MessageRepository {

	void saveMessage(Message message);
	
	List<Message> fetchUnreadMessages(String senderId, String receiverId);

	List<Message> getMessages(String userName);
	

}
