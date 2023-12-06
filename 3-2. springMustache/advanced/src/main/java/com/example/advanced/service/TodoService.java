package com.example.advanced.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    // 전체 데이터 조회
    public List<TodoDto> selectAll()
    {   
        // dao로 받은 조회 데이터(entityList)를 dto로 변경해준다.
        List<TodoEntity> entityList = todoDao.selectAll();

        List<TodoDto> dtoList = new ArrayList<>();
        for(TodoEntity entity : entityList)
        {
            TodoDto dto = new TodoDto(
                entity.getId(), 
                entity.getTodo_name(),
                entity.getStatus());
            dtoList.add(dto);
        }
        return dtoList;
    }
    // 데이터 삽입
    // controller 는 dto만 사용
    // dao는 entity만 사용
    public void insertTodo(String todoName) // todo 이볅을 name만 하므로 
    {                                       // dto 쓸 필요 없음 리턴만 하나로 충분
    
        TodoEntity entity = new TodoEntity();

        entity.setTodo_name(todoName);// 처음등록되는 todo는 상태값이 무저건 false
        entity.setStatus(false);

        todoDao.insertTodo(entity);
    }

    // 데이터 수정
    // id와 status 넘어온다. 
    public void updateTodo(Long id)
    {
        TodoEntity entity = new TodoEntity(); // 두개를 전달하가ㅣ 위해 entity

        entity.setId(id);
        entity.setStatus(true);

        todoDao.updateTodo(entity);
    }

    // 데이터 삭제
    public void deleteTodo(Long id)
    {
        todoDao.deleteTodo(id);
    }
}
