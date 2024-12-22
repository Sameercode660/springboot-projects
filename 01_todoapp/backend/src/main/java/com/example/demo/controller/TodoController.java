package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoServices;

@RestController
@RequestMapping("todo")
public class TodoController {
    
    @Autowired
    TodoServices todoServices;

    @GetMapping
    @CrossOrigin("http://localhost:5173")
    public List<TodoEntity> getTodo() {
        return todoServices.fetchTodo();
    }

    @PostMapping
    @CrossOrigin("http://localhost:5173")
    public boolean addingTodo (@RequestBody TodoEntity todo) {
        todoServices.addTodo(todo);

        return true;
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("http://localhost:5173")
    public boolean removeTodo(@PathVariable String id) {
        return todoServices.deleteTodo(id);
    }

    @PutMapping("/update/{id}")
    @CrossOrigin("http://localhost:5173")
    public boolean updateTodo(@PathVariable String id, @RequestBody TodoEntity todo) {
        TodoEntity oldTodo = todoServices.singleTodo(id).orElse(null);

        if(oldTodo != null) {
            oldTodo.setTitle(todo.getTitle() != null && !todo.getTitle().equals("") ? todo.getTitle() : oldTodo.getTitle());
            oldTodo.setDescription(todo.getDescription() != null && !todo.getDescription().equals("") ? todo.getDescription() : oldTodo.getDescription());            
        }

        todoServices.addTodo(oldTodo);

        return true;
    }
}
