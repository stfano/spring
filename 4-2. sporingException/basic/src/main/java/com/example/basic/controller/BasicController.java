package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.service.BasicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class BasicController {

    @Autowired
    private BasicService basicService;
    

    @GetMapping("/hello/{num}")
    public String hello(@PathVariable int num)
    {
        log.info("[BasicController][hello] 시작 !");
        String msg = "안니영~";
        try
        {
            log.info("[BasicController][hello] try 시작 !");            
            int i =  1 / num;
            log.info("[BasicController][hello] try 끝 !");
        } catch (Exception e)
        {
            log.info("[BasicController][hello] catch 시작 !");
            msg = e.getMessage();
        } finally 
        {
            log.info("[BasicController][hello] finally 시작 !");
        }
        return msg;
    }

    @GetMapping("/exception1")
    public void exception1() throws Exception
    {
        throw new Exception("[BasicController][exception1] 오류발생");
    }

    @GetMapping("/exception2")
    public String exception2() 
    {
        try 
        {
            throw new Exception("[BasicController][exception2] 오류발생");
        } catch (Exception e) 
        {

        }
        return "Good Morning ~";
    }

    // 정상 테스트
    @GetMapping("/ok") 
    public String ok() throws Exception
    {
        return basicService.test();
    }

    // 오류 테스트
    @GetMapping("/exception/controller")
    public String exception3() throws Exception 
    {
        throw new Exception("[BasicController][test] 오류");
    } 

    // service 오류 테스트
    @GetMapping("/exception/service")
    public String exception4() throws Exception 
    {
        return basicService.testException();
    } 

    // dao 오류 테스트 
    @GetMapping("/exception/dao")
    public String exception5() throws Exception 
    {
        return basicService.daoException();
    } 

}
