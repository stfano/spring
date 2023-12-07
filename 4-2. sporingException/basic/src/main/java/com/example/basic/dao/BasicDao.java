package com.example.basic.dao;

import org.springframework.stereotype.Service;

@Service
public class BasicDao {
    
    public String test() throws Exception
    {
        return "[BasicDao][test]정상";
    }

    public String testException() throws Exception
    {
        throw new Exception("[BasicDao][test] 오류");
    }
}
