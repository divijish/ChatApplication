package com.divij.chatapplication.repository;

import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.Message;

@Repository
public interface MessageRepository {

	void saveMessage(Message message);
	

}
