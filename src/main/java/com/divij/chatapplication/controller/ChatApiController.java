package com.divij.chatapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.MessageDto;
import com.divij.chatapplication.service.MessageService;

@RestController
public class ChatApiController {
	
	@Autowired
	private MessageService messageServiceImpl;
	
	@GetMapping("/messages")
	public Object getMessages() {
		
		MessageDto messageDto = messageServiceImpl.getMessages();
		
		return messageDto;
	}
	
	@PostMapping("/message")
	public Object saveMessages(@RequestBody final MessageDto messageDto) {
		
		return "Hello";
	}

}
