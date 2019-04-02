package com.divij.chatapplication.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.Message;
import com.divij.chatapplication.repository.MessageRepository;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveMessage(final Message message) {

		Session session = sessionFactory.getCurrentSession();
		session.save(message);
	}
}
