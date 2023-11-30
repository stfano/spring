package com.example.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.entity.UserEntity;
import com.example.basic.model.repository.UserMapper;


@Service 
public class UserService {
    
    @Autowired // mybatis 가 컴파일을 할때 자동으로 객체를 만들어준다 .// UserMapper는 interface 이므로 만들수 없으므로 autowired 를 써준다 : 자동으로 만들어줘라
    private UserMapper productMapper;

    public List<UserEntity> selectUserAll()
    {
        List<UserEntity> userList = productMapper.selectUserAll();

        return userList;
    }

}

