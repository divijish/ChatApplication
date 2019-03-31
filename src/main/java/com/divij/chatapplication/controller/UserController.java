package com.divij.chatapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.UserListDto;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userServiceImpl;

	@GetMapping("/users")
	public UserListDto getUsers() {
		UserListDto userListDto;// = new UserListDto();
		
		userListDto = userServiceImpl.getUsers();
		return userListDto;
	}
}
