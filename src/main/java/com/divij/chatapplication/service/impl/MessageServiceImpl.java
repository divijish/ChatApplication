package com.divij.chatapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.repository.MessageRepository;
import com.divij.chatapplication.service.MessageService;
import com.divij.chatapplication.value.object.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepositoryImpl;
	
	@Override
	public ReceivedMessageDto getMessages() {
		
		ReceivedMessageDto messageDto = new ReceivedMessageDto();
		MessageVO messageVO = new MessageVO();
		
		
		return null;
	}

	@Override
	public void saveMessage(ReceivedMessageDto messageDto) {
		
		Message message = new Message();
		
		messageRepositoryImpl.saveMessage(message);
	}

}
