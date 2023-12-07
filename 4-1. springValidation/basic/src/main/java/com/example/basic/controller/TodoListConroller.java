package com.example.basic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.TodoListDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/todo")
public class TodoListConroller {
    
    @PostMapping("/join/novalid")
    public String joinNoValid(@RequestBody TodoListDto dto)
    {
        log.info("[TodoListConroller][joinNoValid] 시작");
        log.info("dto : " + dto.toString());
        return "가입 완료 without Validation";
    }

    @PostMapping("/join/valid")
    public String joinValid(@Valid @RequestBody TodoListDto dto)
    {
        log.info("[TodoListConroller][joinValid] 시작");
        log.info("dto : " + dto.toString());
        return "가입 완료 with Validation";
    }
}
