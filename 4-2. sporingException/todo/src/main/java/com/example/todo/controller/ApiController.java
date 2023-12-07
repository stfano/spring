package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.dto.TodoDto;
import com.example.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiController {
    
    @Autowired
    private TodoService todoService;

    public List<TodoDto> selectAll()
    {
        return todoService.selectAll();
    }

    public String insertTodo(TodoDto dto)
    {
        todoService.insertTodo(dto);

        return "저장 성공";
    }

    public String updateTodo(TodoDto dto)
    {
        todoService.updateTodo(dto);

        return "수정 성공";
    }

    public String deleteTodo(Long id)
    {
        todoService.deleteTodo(id);

        return "삭제 성공";
    }


}
