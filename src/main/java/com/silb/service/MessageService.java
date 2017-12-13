package com.silb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silb.model.Message;
import com.silb.model.MessagesDaoImpl;

/**
 * Service class implementation of Messages data access object.
 * @author silberio_stalone
 *
 */
@Service
public class MessageService {

	@Autowired
	private MessagesDaoImpl messageDao;

	public Collection<Message> getAllMessages() {
		return this.messageDao.getAllMessages();
	}
	
	public Message getMessageById(int id) {
		return this.messageDao.getMessageById(id);
	}

	public void removeMessageById(int id) {
		this.messageDao.removeMessageById(id);	
	}
	
	public void updateMessage(Message message) {
		this.messageDao.updateMessage(message);
	}

	public void insertMessage(Message message) {
		this.messageDao.insertMessage(message);
	}
}
