/**
 * package for services
 */
package com.divij.chatapplication.service;


import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserDto;
import com.divij.chatapplication.dto.UserListDto;
import com.divij.chatapplication.entity.User;

/**
 * @author divij
 *
 */
@Service
public interface UserService {

	public UserListDto getUsers();

	void saveUser(UserDto userDto);

	User getUserById(String userId);
}