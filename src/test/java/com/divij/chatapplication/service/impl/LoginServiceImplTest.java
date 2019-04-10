package com.divij.chatapplication.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.divij.chatapplication.repository.LoginRepository;
import com.divij.chatapplication.service.LoginService;
import com.divij.chatapplication.service.UserService;

class LoginServiceImplTest {
	
	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private LoginRepository loginRepositoryImpl;
	
	@Autowired
	private LoginService loginServiceImpl;

	@Test
	void testAuthenticateUser() {
			
		
		
	}

}
