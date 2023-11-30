package com.example.basic.config.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component

// filter는 모든 request를 처리하지만
// interceptor는 모든 request를 처리할 수도 , 못할 수도 있다.


public class BasicInterceptor implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // TODO Auto-generated method stub
        log.info("[BasicInterceptor][afterCompletion] afterCompletion Start ! ");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
// View 의 렌더링이 완료된 후 호출
        // preHandle 에서 true 값이 반환된 경우에만 호출
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        log.info("[BasicInterceptor][postHandle] postHandle Start ! ");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
// Controller 가 실행된 후, 뷰가 렌더링 되기전에 호출
        // Controller의 실행결과를 가지고 후처리작업을 수행할 때 사용
        

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        log.info("[BasicInterceptor][preHandle] preHandle Start ! ");

        return HandlerInterceptor.super.preHandle(request, response, handler);

       
        // Controller가 실행되기전에 호출 
        // true >> 다음 단계로 진행, false >> 처리를 중단하고 요청 처리를 중단 
    }
}

