/**
 * package for services
 */
package com.divij.chatapplication.service;


import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserDto;
import com.divij.chatapplication.dto.UserListDto;

/**
 * @author divij
 *
 */
@Service
public interface UserService {

	public UserListDto getUsers();

	void saveUser(UserDto userDto);
}
