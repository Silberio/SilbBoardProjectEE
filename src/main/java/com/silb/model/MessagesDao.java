package com.silb.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * Repository and CRUD for web service
 * <p>
 * Implementation of MessagesDaoImpl class and methods defined.
 * </p>
 * Currently contains a HashMap where Message objects are stored. Future version
 * may include and implementation for JDBC or MongoDB
 * 
 * @author silberio_stalone
 *
 */
@Repository
public class MessagesDao implements MessagesDaoImpl {

	private Map<Integer, Message> messages = new HashMap<Integer, Message>();

	/**
	 * Retrieves all messages from repository
	 */
	@Override
	public Collection<Message> getAllMessages() {

		return this.messages.values();
	}

	/**
	 * Retrieves a specific message by its ID
	 */
	@Override
	public Message getMessageById(int id) {
		return this.messages.get(id);
	}

	/**
	 * Removes message by id
	 */
	@Override
	public void removeMessageById(int id) {
		this.messages.remove(id);
	}

	/**
	 * Updates a message
	 * <p> 
	 * Does so by taking the new message, replacing it's counterpart
	 * in the repository by id, sets the new text and user to the
	 * new message and .put()s it in the repository.
	 * </p>
	 */
	@Override
	public void updateMessage(Message message) {
		Message msg = messages.get(message.getId());
		msg.setMessage(message.getMessage());
		msg.setUser(message.getUser());
		this.messages.put(message.getId(), message);
	}

	/**
	 * Self explanatory. Inserts a new message into the repository
	 */
	@Override
	public void insertMessage(Message message) {
		this.messages.put(message.getId(), message);
	}

}
