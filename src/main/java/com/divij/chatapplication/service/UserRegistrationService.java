package com.divij.chatapplication.service;

import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.dto.UserRegistrationDto;

public interface UserRegistrationService {
	
	public Response<String> userRegistration(UserRegistrationDto userRegistrationDto);

}
