package com.divij.chatapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.common.CommonUtils;
import com.divij.chatapplication.constants.BusinessExceptionEnum;
import com.divij.chatapplication.dto.Response;
import com.divij.chatapplication.dto.UserRegistrationDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userServiceImpl;

	@GetMapping("/users")
	public Response<List<UserStatusDto>> getUsers() {
		Response<List<UserStatusDto>> response = new Response<>();
		List<UserStatusDto> userList = new ArrayList<>(10);
		userList = userServiceImpl.getUsers();
		response.setResult(userList);
		response.setMessage("Users fetched successfully.");
		response.setStatus("SUCCESS");

		return response;
	}

	@PostMapping("/user")
	public Response createUser(@RequestBody final UserRegistrationDto userDto) {

		Response response = new Response();

		List<BusinessException> businessExceptions = new ArrayList<BusinessException>(0);

		if (CommonUtils.isNullUserRegistrationDto(userDto)) {
			businessExceptions
					.add(BusinessException.getBusinessException(BusinessExceptionEnum.USERNAME_OR_PASSWORD_INVALID));
		} else {

			businessExceptions = userServiceImpl.createUser(userDto);
		}

		if (businessExceptions.size() == 0) {
			response.setMessage("User registered successfully.");
			response.setStatus("SUCCESS");
		} else {
			response.setMessage("User could not be registerd.");
			response.setStatus("FAILED");
			response.setBusinessExceptions(businessExceptions);
		}

		return response;
	}
}
