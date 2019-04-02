package com.divij.chatapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.exception.BusinessException;

@Service
public interface MessageService {

	List<ReceivedMessageDto> fetchMessages(String senderId, String receiverId);

	List<BusinessException> saveMessage(ReceivedMessageDto messageDto, String senderId, String receiverId,
			List<BusinessException> businessExceptions);

}
