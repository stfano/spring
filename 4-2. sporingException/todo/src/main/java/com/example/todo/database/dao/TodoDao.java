package com.example.todo.database.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.database.repository.TodoRepository;
import com.example.todo.model.entity.TodoEntity;

@Service
public class TodoDao {
    
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> selectAll()
    {
        return todoRepository.findAll();
    }

    public void insertTodo(TodoEntity entity)
    {
        todoRepository.save(entity);
    }

    public void updateTodo(TodoEntity entity)
    {
        todoRepository.save(entity);
    }

    public void deleteTodo(Long id)
    {
        todoRepository.deleteById(id);
    }
}
