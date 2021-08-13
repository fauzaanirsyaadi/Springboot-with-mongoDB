package com.fauzaan.springbootmongodb.service;

import com.fauzaan.springbootmongodb.exception.TodoCollectionException;
import com.fauzaan.springbootmongodb.model.TodoDTO;

import javax.validation.ConstraintViolationException;

public interface TodoService {
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException;
}
