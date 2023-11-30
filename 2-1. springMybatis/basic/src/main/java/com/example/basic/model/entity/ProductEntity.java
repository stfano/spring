package com.example.basic.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductEntity {
    
    private int productId; // underscore 에서 camel표기법으로 바꾸어줘야 함
    private String productName;
    private int productPrice;

    
}
