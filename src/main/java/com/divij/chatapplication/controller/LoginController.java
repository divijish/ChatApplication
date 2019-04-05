package com.divij.chatapplication.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divij.chatapplication.constants.BusinessExceptionEnum;
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

	@CrossOrigin
	@PostMapping(value = "login")
	public Response login(@RequestBody UserAuthDto userAuthDto, HttpServletRequest request) {

		List<BusinessException> businessExceptions = new ArrayList<BusinessException>();
		HttpSession httpSession = request.getSession();
		Response response = new Response();

		boolean userExists = false;

		businessExceptions = loginServiceImpl.authenticateUser(userAuthDto, businessExceptions);

		if (businessExceptions.size() != 0) {

			response.setMessage("User could not be logged in.");

			response.setStatus("FAILED");
		} else {

			response.setMessage("User Login operation is successfull");

			httpSession.setAttribute("userName", userAuthDto.getUserName());

			response.setStatus("SUCCESS");
		}

		response.setBusinessExceptions(businessExceptions);

		return response;
	}

	@CrossOrigin
	@GetMapping(value = "/loggeduser")
	public Response<String> getLoggedInUser(HttpServletRequest request) {

		Response<String> response = new Response();
		HttpSession httpSession = request.getSession();
		String userName = "divij";//(String) httpSession.getAttribute("userName");

		//if (userName != null) {

			response.setResult(userName);

			response.setStatus("STATUS");

			response.setMessage("User is logged in.");

		/*} else {

			response.setStatus("FAILED");

			response.setMessage("Could not fetch user.");

			response.setBusinessExceptions(Arrays.asList(new BusinessException[] {
					BusinessException.getBusinessException(BusinessExceptionEnum.USER_NOT_LOGGED_IN) }));
		}*/
		return response;

	}
}
