package com.divij.chatapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.service.LoginService;
import com.divij.chatapplication.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userServiceImpl;

	@Autowired
	LoginService loginServiceImpl;

	@PostMapping(value = "login")
	public Response login(@RequestBody UserAuthDto userAuthDto) {

		List<BusinessException> businessExceptions = new ArrayList<BusinessException>();
		
		Response response = new Response();
		
		boolean userExists = false;
		
		businessExceptions = loginServiceImpl.authenticateUser(userAuthDto, businessExceptions);

		if (businessExceptions.size() != 0) {
	
			response.setMessage("User could not be logged in.");
		
			response.setStatus("FAILED");
		} else {
		
			response.setMessage("User Login operation is successfull");
		
			response.setStatus("SUCCESS");
		}

		response.setBusinessExceptions(businessExceptions);
		
		return response;
	}
}
