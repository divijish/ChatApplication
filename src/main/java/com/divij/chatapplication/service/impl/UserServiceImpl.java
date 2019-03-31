/**
 * 
 */
package com.divij.chatapplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserListDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.repository.UserRepository;
import com.divij.chatapplication.service.UserService;

/**
 * @author divij
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepositoryImpl;

	@Override
	public UserListDto getUsers() {

		UserListDto userListDto = new UserListDto();

		List<UserStatusDto> userList = new ArrayList<UserStatusDto>(0);
		
		userListDto.setUsersList(userList);
		
		return userListDto;
	}

}
