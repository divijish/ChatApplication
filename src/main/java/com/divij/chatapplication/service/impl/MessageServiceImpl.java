package com.divij.chatapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.MessageDto;
import com.divij.chatapplication.service.MessageRepository;
import com.divij.chatapplication.service.MessageService;
import com.divij.chatapplication.value.object.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepositoryImpl;
	
	@Override
	public MessageDto getMessages() {
		
		MessageDto messageDto = new MessageDto();
		MessageVO messageVO = new MessageVO();
		
		
		return null;
	}

}
