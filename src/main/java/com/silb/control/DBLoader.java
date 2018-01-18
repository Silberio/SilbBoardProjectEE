package com.silb.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.silb.model.Message;
import com.silb.model.MessageRepository;

@Component
public class DBLoader implements CommandLineRunner {

	//Creates a local instance of JPA repository
	private final MessageRepository repository;
	
	//initializes the repository
	@Autowired
	public DBLoader(MessageRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		Message msg = new Message("privet", "koshka");
		//A new message is stored with given values
		this.repository.save(msg);
		System.out.println("msg added");
	}

}
