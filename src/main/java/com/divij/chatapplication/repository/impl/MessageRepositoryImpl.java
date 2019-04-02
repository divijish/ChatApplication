package com.divij.chatapplication.repository.impl;

import java.util.List;

import javax.persistence.Query;
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
	
	public List<Message>getMessages(final String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Message message where usr.userName = :name");
		query.setParameter("name", userName);
		List<Message> messages = query.getResultList();
		return messages;
		
		
	}
}
