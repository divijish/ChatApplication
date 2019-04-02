package com.divij.chatapplication.mapper;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.UserDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.entity.User;

@Component
public class UserMapper {

	public UserStatusDto mapEntityToDto(final User user) {

		return null;
	}

	public User mapDtoToEntity(final UserDto userDto, final User user) {
		user.setUserName(userDto.getUserName());

		return user;
	}

}
