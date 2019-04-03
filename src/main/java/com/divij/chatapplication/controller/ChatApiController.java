package com.divij.chatapplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.constants.BusinessExceptionEnum;
import com.divij.chatapplication.dto.ReceivedMessageDto;
import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.service.MessageService;
import com.divij.chatapplication.service.UserService;

@RestController
public class ChatApiController {

	@Autowired
	private MessageService messageServiceImpl;

	@Autowired
	private UserService userServiceImpl;

	/*
	 * This controller is used to receive the messages sent by other user to the
	 * logged in user. Here receiver is the logged in user and sender is the other
	 * person. It returns the received messages(ReceivedMessageDto).
	 */
	@GetMapping("/message/{receiverId}/{senderId}")
	public Response<List<ReceivedMessageDto>> receiveMessages(@PathVariable("receiverId") String receiverId,

			@PathVariable("senderId") String senderId) {

		List<BusinessException> businessExceptions = new ArrayList<BusinessException>();

		boolean receiverExists = userServiceImpl.checkIfUserExists(receiverId);

		boolean senderExists = userServiceImpl.checkIfUserExists(senderId);

		Response<List<ReceivedMessageDto>> response = new Response<>();

		if (receiverExists && senderExists) {

			List<ReceivedMessageDto> messageDto = messageServiceImpl.fetchMessages(senderId, receiverId);

			response.setResult(messageDto);

			response.setStatus("SUCCESS");

			response.setMessage("Messages received");
		} else {
			if (!receiverExists) {

				businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.NO_RECEIVER_USER));

			}
			if (!senderExists) {

				businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.NO_SENDER_USER));
			}

			response.setMessage("Could not fetch messages.");

			response.setStatus("FAILED");

		}

		response.setBusinessExceptions(businessExceptions);

		return response;
	}

	/*
	 * This controller is used to send the messages of the logged in user to the
	 * server which can later be retrieved by the other user. Here the sender is the
	 * logged in user and receiver is the other person.
	 */
	@PostMapping("/message/{senderId}/{receiverId}")
	public Response<String> sendMessage(@RequestBody final ReceivedMessageDto messageDto,

			@PathVariable("senderId") final String senderId, @PathVariable("receiverId") final String receiverId) {

		Response<String> response = new Response<>();

		List<BusinessException> businessExceptions = new ArrayList<>();

		messageServiceImpl.saveMessage(messageDto, senderId, receiverId, businessExceptions);

		if (businessExceptions.size() == 0) {
			response.setMessage("Message successfully sent.");
			response.setStatus("SUCCESS");
		} else {
			response.setMessage("Could not send message.");
			response.setStatus("FAILED");
		}

		response.setBusinessExceptions(businessExceptions);

		return response;
	}

}
