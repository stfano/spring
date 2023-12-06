package com.example.advanced.database.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.repository.TodoRepository;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoDao {
    
    @Autowired
    private TodoRepository todoRepository;

    
    public List<TodoEntity> selectAll() {
        log.info("[TodoDao][selectTodoAll] Start");

        List<TodoEntity> todoList = todoRepository.findAll();
        log.info("todoList: "+todoList.size());
        return todoList;
    }

    public void insertDto(TodoEntity todoEntity)
    {
        todoRepository.save(todoEntity);
    }

    public void updateDto(TodoEntity todoEntity)
    {

        TodoEntity updateTodo = todoRepository.getReferenceById(todoEntity.getId());
        todoRepository.save(updateTodo);
    }

    public void deleteDto(Long id)
    {
        TodoEntity deleteTodo = todoRepository.getReferenceById(id);
        todoRepository.delete(deleteTodo);
    }
    
}
