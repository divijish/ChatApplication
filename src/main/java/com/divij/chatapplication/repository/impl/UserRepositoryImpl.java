/**
 * 
 */
package com.divij.chatapplication.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.repository.UserRepository;

/**
 * @author divij
 *
 */
public class UserRepositoryImpl implements UserRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.divij.chatapplication.service.UserRepository#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		User[] userListArray = { new User(), new User() };
		List<User> userList = new ArrayList<User>(Arrays.asList(userListArray));
		return userList;
	}

}
