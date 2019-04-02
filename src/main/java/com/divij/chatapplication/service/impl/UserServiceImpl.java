/**
 * 
 */
package com.divij.chatapplication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserRegistrationDto;
import com.divij.chatapplication.dto.UserListDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.entity.UserAuth;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.mapper.UserMapper;
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

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserStatusDto> getUsers() {

		List<User> userList;
		userList = userRepositoryImpl.getUsers();

		List<UserStatusDto> userStatusList = userList.stream()
				.map(user -> userMapper.mapEntityToDto(user, new UserStatusDto())).collect(Collectors.toList());
		
		//UserStatusDto x= userMapper.mapDtoToEntity(null, null);

		return userStatusList;
	}

	@Override
	public List<BusinessException> createUser(final UserRegistrationDto userDto) {

		User user = new User();
		List<BusinessException> businessExceptions = new ArrayList<>(0);
		boolean userExists =  checkIfUserExists(userDto.getUserName());

		if (!userExists) {
			UserAuth userAuth = new UserAuth();
			userAuth = userMapper.mapDtoToEntity(userDto, userAuth);
			userRepositoryImpl.registerUser(userAuth);
			user = userMapper.mapDtoToEntity(userDto, user);// (user, userDto);

			userRepositoryImpl.createUser(user);
		} else {

			businessExceptions.add(new BusinessException("CA1001", "USER WITH PROVIDED NAME ALREADY EXISTS."));
		}

		return businessExceptions;
	}

	private boolean checkIfUserExists(String userName) {

		boolean userExists = userRepositoryImpl.checkIfUserExists(userName);

		return userExists;
	}

	@Override
	public User getUserById(String userName) {

		User user = userRepositoryImpl.getUserByName(userName);

		return user;
	}

}
