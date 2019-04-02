package com.divij.chatapplication.mapper;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.UserRegistrationDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.entity.UserAuth;

@Component
public class UserMapper {

	

	public User mapDtoToEntity(final UserRegistrationDto userDto, final User user) {
		user.setUserName(userDto.getUserName());

		return user;
	}

	public UserAuth mapDtoToEntity(final UserRegistrationDto userDto, final UserAuth userAuth) {
		userAuth.setUserName(userDto.getUserName());
		userAuth.setPassword(userDto.getPassword());
		userAuth.setRegisteredTimestamp(new Timestamp(new Date().getTime()));
		return userAuth;
	}
	
	public UserStatusDto mapEntityToDto(final User user, final UserStatusDto userStatusDto) {
		
		userStatusDto.setUserName(user.getUserName());
		userStatusDto.setOnlineStatus(true);//assuming everyone is online.
		
		return userStatusDto;
	}

}
