package com.divij.chatapplication.service;

import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.MessageDto;

@Service
public interface MessageService {

	MessageDto getMessages();

}
