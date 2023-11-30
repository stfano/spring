package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.entity.UserEntity;
import com.example.basic.service.UserService;

@RestController
@RequestMapping("/ver1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserEntity> selectUserAll()
    {
        return userService.selectUserAll();
    }
}
