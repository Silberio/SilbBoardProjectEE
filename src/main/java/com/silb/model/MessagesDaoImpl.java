package com.silb.model;

import java.util.Collection;


public interface MessagesDaoImpl {

	Collection<Message> getAllMessages();

	Message getMessageById(int id);

	void removeMessageById(int id);

	void updateMessage(Message message);

	void insertMessage(Message message);
}
