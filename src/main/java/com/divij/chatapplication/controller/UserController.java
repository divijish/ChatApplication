package com.divij.chatapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.dto.UserDto;
import com.divij.chatapplication.dto.UserListDto;
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

	@PostMapping("/user")
	public Response saveUser(@RequestBody final UserDto userDto) {

		Response response = new Response();
		userServiceImpl.saveUser(userDto);
		response.setResult(true);
		return response;
	}
}
