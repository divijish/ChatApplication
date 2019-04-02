package com.divij.chatapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.service.MessageService;

@RestController
public class ChatApiController {

	@Autowired
	private MessageService messageServiceImpl;

	@GetMapping("/messages")
	public Response<ReceivedMessageDto> getMessages() {

		Response<ReceivedMessageDto> response = new Response<>();
		ReceivedMessageDto messageDto = messageServiceImpl.getMessages();
		response.setResult(messageDto);
		return response;
	}

	@PostMapping("/message")
	public Response<String> saveMessage(@RequestBody final ReceivedMessageDto messageDto) {

		Response<String> response = new Response<>();
		
		messageServiceImpl.saveMessage(messageDto);

		return response;
	}

}
