package com.divij.chatapplication.validator;

public interface MessageRequestValidator {
	
	public boolean checkIfUsersExist(String receiverId, String senderId);

}
