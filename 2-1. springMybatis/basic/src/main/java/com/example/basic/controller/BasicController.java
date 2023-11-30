package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/ver1/basic")
public class BasicController {
    
    // localhost:8080/ver1/basic/hello
    @GetMapping("/hello")
    public String hello()
    {
        log.info("[BasicController][hello] 안니영~");
        return "안니용 ~ ";
    }
}
