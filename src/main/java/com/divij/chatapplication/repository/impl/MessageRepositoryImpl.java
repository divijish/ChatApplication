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

	/*
	 * This method saves the provided message.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.MessageRepository#saveMessage(com.divij.
	 * chatapplication.entity.Message)
	 */
	@Override
	public void saveMessage(final Message message) {

		Session session = sessionFactory.getCurrentSession();
		session.save(message);
	}

	@Override
	public List<Message> getMessages(final String userName) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Message message where usr.userName = :name");
		query.setParameter("name", userName);
		List<Message> messages = query.getResultList();
		return messages;

	}
	/*
	 * This method fetches list of messages in which the sender is user with
	 * userName as senderId and receiver is user with userName as receiverId.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.MessageRepository#fetchMessages(java.
	 * lang.String, java.lang.String)
	 */

	@Override
	public List<Message> fetchMessages(String senderId, String receiverId) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(
				"From Message msg where msg.sender.userName=:senderId and msg.receiver.userName=:receiverId order by msg.messageTimestamp");

		query.setParameter("senderId", senderId);
		
		query.setParameter("receiverId", receiverId);
		
		List<Message> messageList = (List<Message>) query.getResultList();
		
		return messageList;
	}
}
