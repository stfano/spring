package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.UserDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
    
    @GetMapping("/hello")
    public String hello()
    {
        log.info("[UserController][hello] 시작");
        return "안니영~";
    }

    @PostMapping("/join/novalid")
    public String joinNoValid(@RequestBody UserDto dto)
    {
        log.info("[UserController][joinNoValid] 시작");
        log.info("dto : " + dto.toString());
        return "가입 완료 without Validation";
    }

    @PostMapping("/join/valid")
    public String joinValid(@Valid @RequestBody UserDto dto)
    {
        log.info("[UserController][joinValid] 시작");
        log.info("dto : " + dto.toString());
        return "가입 완료 with Validation";
    }
}
