package com.example.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.config.interceptor.BasicInterceptor;

@Configuration

public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(new BasicInterceptor())
                .addPathPatterns("/**") // * : /가 하나인 것만 적용, ** : /가 여러개에 적용
                .excludePathPatterns("/admin/**"); // admin이 들어온다면 적용시키지 않음
                
    }
}
