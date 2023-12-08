package com.example.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링 설정객체
@EnableWebSecurity // 스프링 시큐리티 설정 객체

// @Controller의 Method(Servlet)에서
// 해당 어노테이션 활성화 @Secured, @PreAuthorize
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
    
    @Bean // 해당 메서드의 리턴되는 ㅇ브젝트(암호화 객체)를 Ioc로 등록
    public BCryptPasswordEncoder encodeePwd()
    {
        return new BCryptPasswordEncoder();
    }

    // 인증, 인가
    // Configuring HttpSecurity

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf(AbstractHttpConfigurer::disable);
        http
            // url path에 대한 접근 권한 설정
            .authorizeHttpRequests(authorize -> authorize
                // 인증이 성공했을 때, (인가(권한)은 확인하지 않음)
                .requestMatchers("/user/**").authenticated()
                // 인증(로그인) & 인가(권한)모두 확인 
                .requestMatchers("/admin/**")
                    .hasAnyAuthority("ADMIN")
                // 그 외의 모든 url은 다 허락함
                // 인증 & 인가를 확인하지 않음
                .anyRequest().permitAll()
            )
            // 인증(로그인) 에대한 세부 설정
            .formLogin(fomrLogin -> fomrLogin
                // 로그인 접속 화면 url path
                .loginPage("/loginPage")
                // 로그인 성공을 했을 때
                // PrincipalDetailsService.loadUserDtoByUserId() 실행
                .loginProcessingUrl("/login")
            );
        return http.build();
    }
}
