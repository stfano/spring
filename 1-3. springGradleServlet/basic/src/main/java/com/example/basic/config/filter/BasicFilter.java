package com.example.basic.config.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // 작성해 주어야 spring이 Filter 를 인식한다.
public class BasicFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        log.info("[BasciFilter][doFilter] 안니영~");

        chain.doFilter(request, response);

        // filter가 먼저 실행된 후 hello 메서드가 실행된다.
    }
        
    
}
