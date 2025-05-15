package com.example.musicschool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicschool.entity.Todo;
import com.example.musicschool.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        logger.info("TodoController.getAllTodos() が呼ばれました");
        List<Todo> todos = todoService.getAllTodos();
        logger.info("TodoService からのレスポンス: {}", todos);
        return todos;
    }

}
