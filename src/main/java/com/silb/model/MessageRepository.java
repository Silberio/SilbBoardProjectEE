package com.silb.model;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
	
}