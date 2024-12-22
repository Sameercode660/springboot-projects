package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;

@Component
public class TodoServices {
    
    @Autowired
    TodoRepository todoRepository;
    
        public void addTodo(TodoEntity todo) {
            todoRepository.save(todo);
        }
    
        public List<TodoEntity> fetchTodo() {
            return todoRepository.findAll();
        }
    
        public boolean deleteTodo(String id) {
            todoRepository.deleteById(id);
            return true;
        }
    
        public Optional<TodoEntity> singleTodo(String id) {
            return todoRepository.findById(id);
    }
}
