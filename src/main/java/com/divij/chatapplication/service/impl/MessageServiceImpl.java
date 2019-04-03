package com.divij.chatapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.constants.BusinessExceptionEnum;
import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.mapper.MessageMapper;
import com.divij.chatapplication.repository.MessageRepository;
import com.divij.chatapplication.service.MessageService;
import com.divij.chatapplication.service.UserService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepositoryImpl;

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private UserService userServiceImpl;

	/*
	 * This method fetches messages in list of entity and maps it to another list of
	 * dto and returns it.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.service.MessageService#fetchMessages(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<ReceivedMessageDto> fetchMessages(String senderId, String receiverId) {

		List<Message> messageList = messageRepositoryImpl.fetchMessages(senderId, receiverId);

		List<ReceivedMessageDto> messageDtoList = messageList.stream()

				.map(message -> messageMapper.mapEntityToDto(message, new ReceivedMessageDto()))

				.collect(Collectors.toList());

		return messageDtoList;
	}

	/*
	 * This method checks if the receiver and sender users exist in db and if they
	 * do exist then saves the message otherwise returns business exceptions stating
	 * the same. (non-Javadoc)
	 * 
	 * @see com.divij.chatapplication.service.MessageService#saveMessage(com.divij.
	 * chatapplication.dto.ReceivedMessageDto, java.lang.String, java.lang.String,
	 * java.util.List)
	 */
	@Override
	public List<BusinessException> saveMessage(final ReceivedMessageDto messageDto, final String senderId,
			final String receiverId, List<BusinessException> businessExceptions) {

		boolean senderExists = userServiceImpl.checkIfUserExists(senderId);

		boolean receiverExists = userServiceImpl.checkIfUserExists(receiverId);

		if (senderExists && receiverExists) {

			Message message = new Message();

			message = messageMapper.mapDtoToEntity(messageDto, message);

			User receiverUser = userServiceImpl.getUserByUserName(receiverId);

			User loggedUser = userServiceImpl.getUserByUserName(senderId);

			message.setReceiver(receiverUser);

			message.setSender(loggedUser);

			messageRepositoryImpl.saveMessage(message);

		}

		else {

			if (!senderExists) {

				businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.NO_SENDER_USER));
			}

			if (!receiverExists) {

				businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.NO_RECEIVER_USER));
			}

		}

		return businessExceptions;

	}

}
