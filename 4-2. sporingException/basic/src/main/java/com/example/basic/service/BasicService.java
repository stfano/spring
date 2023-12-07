package com.example.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.dao.BasicDao;

@Service
public class BasicService {
    
    @Autowired
    private BasicDao basicDao;

    // 정상
    public String test() throws Exception
    {
        return basicDao.test();
    }

    // Dao 오류 테스트
    public String daoException() throws Exception
    {
        return basicDao.testException();
    }

    // 오류 테스트 
    public String testException() throws Exception
    {
        throw new Exception("[BasicService][testException] 오류");
    }
}
