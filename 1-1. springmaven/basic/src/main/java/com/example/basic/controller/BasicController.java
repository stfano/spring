package com.example.basic.controller;


import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.UserDto;

@RestController // 사용자의 요청 url를 처리한다.
public class BasicController {
    
    // http://localhost:8080/hello 에 접속되면 getHello 함수가 호출
    @GetMapping("/hello1") // servlet class만 Getmapping 을 가질수 있다. 
    public String getHellO1()
    {
        return "코딩출력";
    }
    // 어노테이션으로 spring이 자동으로 새로운 new basic 인스턴스 생성 

    // RestController는 선언하고 GetMapping을 선언하지 않는다면 url 주소가 없다는 뜻이므로
    // url 매핑이 되지않는다. 
    @GetMapping("/student")
    public String getStudent()
    {
        return "코딩공부하는 학생입니다.";
    }

    @PostMapping("/variable1")
    public String postVariable1(@RequestBody Map<String, Object> params)
    {
        String msg = "";

        for (String key: params.keySet())
        {
            msg += (String)params.get(key);
        }
        return msg;
    }

    @GetMapping("/hello")
    public String getHello()
    {
        return "Hello World";
    }

    @RequestMapping(value = "/dto1" , method = RequestMethod.POST)
    public String postDto1(@RequestBody UserDto dto)
    {
        return dto.toString();
    }
}


