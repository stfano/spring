package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.entity.ProductEntity;

@Mapper  // ProductMapper.xml과 매핑시켜서 동일해짐
public interface ProductMapper {

    List<ProductEntity> selectProductAll();

    List<ProductEntity> selectProductFilter(
        @Param("productPrice") int productPrice,
        @Param("productName") String productName
    );
} 
    

