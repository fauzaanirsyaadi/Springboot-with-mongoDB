package com.fauzaan.springbootmongodb.repository;

import com.fauzaan.springbootmongodb.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

//    add query
    @Query("{'todo':?0}")
    Optional<TodoDTO> findByTodo(String todo);
}
