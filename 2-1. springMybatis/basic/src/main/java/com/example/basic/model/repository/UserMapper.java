package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.basic.model.entity.UserEntity;

@Mapper
public interface UserMapper {

    List<UserEntity> selectUserAll();
    
} 
