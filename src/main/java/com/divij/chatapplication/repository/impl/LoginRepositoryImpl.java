package com.divij.chatapplication.repository.impl;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.repository.LoginRepository;

@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean authenticateUser(UserAuthDto userAuthDto) {

		Session session = sessionFactory.getCurrentSession();
		boolean userAuthenticated = false;

		Query query = session
				.createQuery("select count(*) from UserAuth ua where ua.userName=:userName and ua.password=:password");

		query.setParameter("userName", userAuthDto.getUserName());
		query.setParameter("password", userAuthDto.getPassword());

		Long userCounter = (Long) query.getSingleResult();

		if (userCounter != 0) {
			userAuthenticated = true;
		}

		return userAuthenticated;
	}

}
