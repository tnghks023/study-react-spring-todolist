package com.suhwan.todolist.service;

import com.suhwan.todolist.repository.Todo;
import com.suhwan.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Todo insertTodo(String todoName) {
        Todo todo = new Todo();
        todo.setTodoName(todoName);
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long todoId) throws Exception {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new Exception("Todo not found!"));
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
