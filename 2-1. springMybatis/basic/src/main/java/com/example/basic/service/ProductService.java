package com.example.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.entity.ProductEntity;
import com.example.basic.model.repository.ProductMapper;

@Service 
public class ProductService {
    
    @Autowired // mybatis 가 컴파일을 할때 자동으로 객체를 만들어준다 .// pridcutMapper는 interface 이므로 만들수 없으므로 autowired 를 써준다 : 자동으로 만들어줘라
    private ProductMapper productMapper;

    public List<ProductEntity> selectProductAll()
    {
        List<ProductEntity> productList = productMapper.selectProductAll();

        return productList;
    }

    public List<ProductEntity> selectProductFilter(ProductEntity product)
    {
        List<ProductEntity> productList = productMapper.selectProductFilter(
            product.getProductPrice(), product.getProductName()
        );
        return productList;
    }

}
