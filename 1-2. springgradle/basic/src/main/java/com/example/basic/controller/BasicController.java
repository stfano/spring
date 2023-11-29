package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.BasicDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // method : GET & url : /hello
public class BasicController {

    @GetMapping("/hello")
    public String getHello()
    {
        
        String msg = "Hello World";
        
        System.out.println("msg: " + msg); // sout + tab

        return msg;
    }

    // localhost:8080/variable/Nice
    // Good => param
    @GetMapping("/variable/{param}")  // String param과  {} 안에 변수가 같아야함 
    public String getHello2(@PathVariable String param)
    {

        log.info("URL으로부터 param을 받았어 !  > " + param);
        return param;
    }

    @GetMapping("/variable4/{param}")  // String param과  {} 안에 변수가 같아야함 
    // path는 unique 해야함 동일한 url 값이 나오면 X
    // {param} != name이 같지 않지만 @PathVariable("param") 을 통해 
    // mapping시켜주어서 error 가 발생하지 않음
    public String getHello4(@PathVariable("param") String name)
    {

        log.info("URL으로부터 param을 받았어 !  > " + name);
        return name;
    }

    @GetMapping("/variable/{param1}/{param2}")  // String param과  {} 안에 변수가 같아야함 
    public String getHello3(@PathVariable String param1, @PathVariable String param2)
    {

        log.info("URL으로부터 param1을 받았어 !  > " + param1);
        return param2;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    // RestController 는 method = GET이 default 값임
    // RequesMapping은 수정할 수 있음.
    public String getHello1()
    {
        String msg = "Hello World";
        log.info("msg :" + msg);
        return msg;
    }

    @GetMapping("/logging")
    public String getLogging()
    {

        log.info("logging에 들어왔어~");
        return "logging 했어~";
    }
    
    // localhost:8080/query?key=value
    // localhost:8080/query?key=hello world
    @GetMapping("/query")
    public String getQuery1(@RequestParam String key)
    {
        log.info("어서와 query는 처음이지..?");
        return key; 
    }

    // localhost:8080/query?key1=value1&key2=value2&key3=value3
    @GetMapping("/query2")
    public String getQuery2(@RequestParam String key1
                            ,@RequestParam String key2
                            ,@RequestParam String key3)
    {
        log.info("어서와 다중 query는 처음이지..?");
        return key1 + key2 + key3; 
    }

    // key,value를 입력하지않아도 수백, 수천개 입력 가능하다. 
    // localhost:8080/query?key1=value1&key2=value2&key3=value3
    @GetMapping("/query3")
    public String getQuery3(@RequestParam Map<String, Object> params)
    {
        log.info("어서와 다중 query3는 처음이지..?");
        String msg = "";

        for (String key: params.keySet())
        {
            msg = msg + (String)params.get(key);
        }

        return msg; 
    }

    // localhost:8080/dto1?name=홍승표&email=stfano08@gmail.com
    @GetMapping("/dto1")
    public String getDto1(@ModelAttribute BasicDto dto) // @ModelAttribute 는 요청의
                                            // 매개변수들을 자바 객체로 변환 
                                    // 즉 BasicDto 클래스의 객체로 매핑
    {

        return dto.toString();  //dto.getName() + dto.getEmail(); 
    }
}
