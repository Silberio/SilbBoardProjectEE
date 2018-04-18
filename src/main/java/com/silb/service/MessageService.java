package com.silb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import com.silb.model.BoardRepository;
import com.silb.model.Message;

/**
 * Service class implementation of Message repository.
 * 
 * @author silberio_stalone
 *
 */
@Repository
public class MessageService implements CommandLineRunner {

	private final BoardRepository repository;

	@Autowired
	public MessageService(BoardRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... Strings) throws Exception {

		this.repository.save(new Message("first message", "Silb"));
		this.repository.save(new Message("second message", "Dog"));
		this.repository.save(new Message("third message", "God"));

	}

	/*
	 * CRUD stuff below
	 */
	
	public void addMessage(Message msg) {
		this.repository.save(msg);
	}

	public Message getMessage(Message msg) {
		return this.repository.findOne(msg.getId());
	}
	
	public void replaceMessage(Message msg, Message newMsg) {
		this.repository.delete(msg);
		newMsg.setId(msg.getId());	
		this.repository.save(newMsg);
	}
	
	
	public void deleteMessage(Message msg) {
		this.repository.delete(msg);
	}
}
