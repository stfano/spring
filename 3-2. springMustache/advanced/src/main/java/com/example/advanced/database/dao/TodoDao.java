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

    // 전체 데이터 조회
    public List<TodoEntity> selectAll()
    {
        log.info("[TodoDao][selectAll] 안니영 ~");
        List<TodoEntity> entityList = todoRepository.findAll();

        log.info("entityList count :" + entityList.size());
        return entityList;
    }

    // 데이터 삽입
    public void insertTodo(TodoEntity entity) // Dao 는 Entity를 받으므로 Entity 작성 
    {
        log.info("[TodoDao][insertTodo] 안니영 ~");
        log.info("entity : "+entity.toString()); // 이 데이터가 저장되었다~~

        todoRepository.save(entity); // jpa에 내장되어있는 save 메서드 이용
    }

    // 데이터 수정
    // false -> true 변경된 내용을 저장.
    public void updateTodo(TodoEntity entity)
    { 
        log.info("[TodoDao][updateTodo] 안니영 ~");
        log.info("entity : "+entity.toString());
        // entity : 화면에서 넘어온 수정할 데이터 
        // 1. mysql 에 있는 저정된 savedentity를 조회한 후 
        TodoEntity savedEntity = todoRepository.getReferenceById(entity.getId());

        if (entity.getStatus().equals(true)) /// null or equals(true)
        {
            log.info("[TodoDao][updateTodo] 수정中");
            // 2. 저장된 savedentity에 수정할 데이터(entity)를 update 한다.
            savedEntity.setStatus(entity.getStatus()); // setStatus : 업데이트 하겠다. 
            // 3. savedEntity에는 수정할 데이터가 적용된 것 
            todoRepository.save(savedEntity);
        }
    }

    // 데이터 삭제
    public void deleteTodo(Long id)
    {
        log.info("[TodoDao][deleteTodo] 안니영 ~");
        log.info("id :" + id);
        todoRepository.deleteById(id);
    }
}
