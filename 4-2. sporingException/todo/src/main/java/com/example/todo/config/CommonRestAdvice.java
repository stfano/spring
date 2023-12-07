package com.example.todo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommonRestAdvice {
    
    public ResponseEntity<Map<String, Object>> defaultExceptionHandler(Exception e)
    {
        log.info(null);
    }
}
