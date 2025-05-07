package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
