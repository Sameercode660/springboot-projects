package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.TodoEntity;

public interface TodoRepository extends MongoRepository<TodoEntity, String>{
    
}
