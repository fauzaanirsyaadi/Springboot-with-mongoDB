package com.fauzaan.springbootmongodb.service.impl;

import com.fauzaan.springbootmongodb.exception.TodoCollectionException;
import com.fauzaan.springbootmongodb.model.TodoDTO;
import com.fauzaan.springbootmongodb.repository.TodoRepository;
import com.fauzaan.springbootmongodb.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepo;

    @Override
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todoOptional = todoRepo.findByTodo(todo.getTodo());
        if (todoOptional.isPresent()){
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }else{
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }

    }
}
