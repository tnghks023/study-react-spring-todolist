package com.suhwan.todolist.controller;

import com.suhwan.todolist.repository.Todo;
import com.suhwan.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Iterable<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public Todo insertTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.insertTodo(todoRequest.todoName());
    }

    @PutMapping("/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") Long todoId) throws Exception {
        return todoService.updateTodo(todoId);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
