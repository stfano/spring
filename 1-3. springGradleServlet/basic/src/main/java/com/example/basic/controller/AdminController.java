package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin") // admin으로 시작하는 모든 요청..
public class AdminController {
    
    // localhost:8080/admin/hello
    @GetMapping("/hello")
    public String hello()
    {
        log.info("[AdminController][hello] 시작 !");
        return "admin 안니영~ ";
    }

    // localhost:8080/admin/world
    @GetMapping("/world")
    public String world()
    {
        log.info("[AdminController][world] 시작 !");
        return "admin 배위~ ";
    }


}
