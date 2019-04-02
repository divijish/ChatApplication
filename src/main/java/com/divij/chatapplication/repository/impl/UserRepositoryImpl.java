/**
 * 
 */
package com.divij.chatapplication.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divij.chatapplication.constants.ParameterConstants;
import com.divij.chatapplication.constants.QueryEnum;
import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.entity.UserAuth;
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

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("From User");

		List<User> userList = (List<User>) query.getResultList();

		return userList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.UserRepository#createUser(com.divij.
	 * chatapplication.entity.User)
	 */
	@Override
	public void createUser(final User user) {

		Session session = sessionFactory.getCurrentSession();
		session.save(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.UserRepository#getUserByName(java.lang.
	 * String)
	 */

	@Override
	public User getUserByName(final String userName) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("From User usr where usr.userName=:usrName");
		query.setParameter("usrName", userName);

		User user = (User) query.getResultList().get(0);

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.UserRepository#checkIfUserExists(java.
	 * lang.String)
	 */
	@Override
	public boolean checkIfUserExists(String userName) {

		Session session = sessionFactory.getCurrentSession();
		boolean userExists = true;
		Query query = session.createQuery(QueryEnum.CHECK_IF_USER_EXISTS_QUERY.getQuery());
		query.setParameter(ParameterConstants.USER_NAME.getParameter(), userName);

		Long userCount = (Long) query.getResultList().get(0);

		if (userCount == 0) {
			userExists = false;
		}

		return userExists;
	}

	@Override
	public void registerUser(UserAuth userAuth) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userAuth);
	}

}
