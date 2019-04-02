package com.divij.chatapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.mapper.MessageMapper;
import com.divij.chatapplication.repository.MessageRepository;
import com.divij.chatapplication.service.MessageService;
import com.divij.chatapplication.service.UserService;
import com.divij.chatapplication.value.object.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepositoryImpl;

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private UserService userServiceImpl;

	@Override
	public ReceivedMessageDto getMessages() {

		ReceivedMessageDto messageDto = new ReceivedMessageDto();
		MessageVO messageVO = new MessageVO();

		return null;
	}

	/*
	 * Here, always the person(friend) whom the logged in user is chatting with will
	 * be on the receiving side of the message.
	 */
	@Override
	public void saveMessage(ReceivedMessageDto messageDto) {

		Message message = new Message();

		message = messageMapper.mapDtoToEntity(messageDto, message);
		User receiverUser = userServiceImpl.getUserById(messageDto.getFriendId());
		User loggedUser = userServiceImpl.getUserById("Divij");
		message.setReceiver(receiverUser);
		message.setSender(loggedUser);

		messageRepositoryImpl.saveMessage(message);
	}

}
