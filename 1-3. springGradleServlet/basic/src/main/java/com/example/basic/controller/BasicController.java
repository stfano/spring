package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.BasicDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BasicController {
    
    @GetMapping("/hello")
    public String getHello()
    {
        log.info("[BasicController][hello] Start !!");
        return "Hello World";
    }

    @GetMapping("/query")
    public int getName(@RequestParam int params)
    {
        int age = 2023 - params;
        
        log.info("[BasicController][query] Start !!");
        return age;
    }

    @GetMapping("/query2")
    public String getName2(@RequestParam Map<String,Object> params)
    {
        String msg = "";
        log.info("[BasicController][query2] Start !!");

        for (String key : params.keySet())
        {
            msg += msg + (String)params.get(key);
        }

        return msg;
    }

    // localhost:8080/dto1?name=sseungpp&age=25
    @GetMapping("/dto1")
    public String dto1(@ModelAttribute BasicDto dto)
    {
        log.info("[BasicController][dto1] 지진 발생 !");
        return dto.toString();
    }
}
