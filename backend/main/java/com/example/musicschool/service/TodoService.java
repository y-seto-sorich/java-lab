package com.example.musicschool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.musicschool.entity.Todo;
import com.example.musicschool.repository.TodoRepository;

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
