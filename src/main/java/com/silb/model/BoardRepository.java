package com.silb.model;

import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Message, Long> {

}
