package com.divij.chatapplication.service;

import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.ReceivedMessageDto;

@Service
public interface MessageService {

	ReceivedMessageDto getMessages();

	void saveMessage(ReceivedMessageDto messageDto);

}
