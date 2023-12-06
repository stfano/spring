package com.example.advanced.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    public List<TodoDto> selectAll() {
        log.info("[TodoService][selectTodoAll] Start");

        // Dao와 상호작용하는 조회쿼리문을 가져와 리스트에 저장한다. 
        List<TodoEntity> entityList = todoDao.selectAll();

        // entityList 에 담긴 만큼 반복하여 id,title,status를 반환하여 저장한다. 
        List<TodoDto> todoList = new ArrayList<>();
        for(TodoEntity entity:entityList) {
            TodoDto dto = new TodoDto(entity.getId(), entity.getTitle(), entity.getStatus());
            todoList.add(dto);
        }
        // 리스트로 저장된 값을 반환한다. 
        return todoList;
    }

    public void insertDto(TodoDto dto)
    {
        log.info("[TodoService][insertDto] 안니영~ ");

        dto.setStatus("false");
        TodoEntity entity = new TodoEntity();
        entity.setTitle(dto.getTitle());
        entity.setStatus(dto.getStatus());

        todoDao.insertDto(entity);
    }   

    public void updateDto(Long id)
    {
        log.info("[TodoService][insertDto] 안니영~ ");

        TodoEntity entity = new TodoEntity();
        entity.setId(id);
        entity.setStatus("true");
        todoDao.updateDto(entity);
    }  

    public void deleteDto(Long id)
    {
        log.info("[TodoService][insertDto] 안니영~ ");

        todoDao.deleteDto(id);
    }  
}
