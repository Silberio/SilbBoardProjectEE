package com.silb.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MessagesDao implements MessagesDaoImpl {
	
private Map<Integer, Message> messages = new HashMap<Integer, Message>();

	@Override
	public Collection<Message> getAllMessages() {
		
		return this.messages.values();
	}

	@Override
	public Message getMessageById(int id) {
		return this.messages.get(id);
	}

	@Override
	public void removeMessageById(int id) {
		this.messages.remove(id);
	}

	@Override
	public void updateMessage(Message message) {		
		Message msg = messages.get(message.getId());
		msg.setMessage(message.getMessage());
		msg.setUser(message.getUser());
		this.messages.put(message.getId(), message);
	}

	@Override
	public void insertMessage(Message message) {
		this.messages.put(message.getId(), message);		
	}

}
