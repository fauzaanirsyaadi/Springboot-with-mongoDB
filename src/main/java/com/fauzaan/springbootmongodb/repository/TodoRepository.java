package com.fauzaan.springbootmongodb.repository;
import java.util.Optional;

import com.fauzaan.springbootmongodb.model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

    @Query("{'todo': ?0}")
    Optional<TodoDTO> findByTodo(String todo);
}