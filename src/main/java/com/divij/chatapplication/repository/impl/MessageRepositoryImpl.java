package com.divij.chatapplication.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	 * This method fetches list of unread messages in which the sender is user with
	 * userName as senderId and receiver is user with userName as receiverId parameter and after fetching the list 
	 * of messages, saves the messages back after setting the isRead attribute to true(since the message is read now)
	 * and returns the list of unread messages.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.repository.MessageRepository#fetchMessages(java.
	 * lang.String, java.lang.String)
	 */

	@Override
	public List<Message> fetchUnreadMessages(String senderId, String receiverId) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("From Message msg where msg.sender.userName=:senderId and"
				+ " msg.receiver.userName=:receiverId and msg.isRead=:readValue order by msg.messageTimestamp");

		query.setParameter("senderId", senderId);

		query.setParameter("receiverId", receiverId);

		query.setParameter("readValue", false);

		List<Message> unreadMessageList = (List<Message>) query.getResultList();

		List<Message> readMessageList = unreadMessageList.stream().map(message -> {

			Message newMessage = new Message(message);

			return newMessage;

		}).collect(Collectors.toList());

		readMessageList.stream().forEach(message -> {
			message.setRead(true);
			session.save(message);
		});

		return unreadMessageList;
	}
}
