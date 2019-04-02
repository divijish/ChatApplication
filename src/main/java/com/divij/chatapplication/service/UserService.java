/**
 * package for services
 */
package com.divij.chatapplication.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserRegistrationDto;
import com.divij.chatapplication.dto.UserStatusDto;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.exception.BusinessException;

/**
 * @author divij
 *
 */
@Service
public interface UserService {

	public List<UserStatusDto> getUsers();

	List<BusinessException> createUser(UserRegistrationDto userDto);

	User getUserById(String userId);
}