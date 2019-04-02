/**
 * 
 */
package com.divij.chatapplication.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.repository.UserRepository;

/**
 * @author divij
 *
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

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

	@Override
	public void saveUser(final User user) {

		Session session = sessionFactory.getCurrentSession();

		session.save(user);

	}

}
