package com.divij.chatapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.MessageDto;

@RestController
public class ChatApiController {
	
	@GetMapping("/messages")
	public Object getMessages() {
		
		return "message";
	}
	
	@PostMapping("/message")
	public Object saveMessages(@RequestBody final MessageDto messageDto) {
		
		return "Hello";
	}

}
