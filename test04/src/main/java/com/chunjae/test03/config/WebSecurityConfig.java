package com.chunjae.test03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    // passwordEncoder 빈 등록
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 공통 접근 설정
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "login.do", "join.do").permitAll()    // 열거 순서 중요 - permitAll() : 모든 사람 접근 가능
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .requestMatchers("/emp/**").hasAnyRole("ADMIN", "EMP")
                .anyRequest().authenticated();
        
        // 로그인 설정
        http.formLogin()
                .loginPage("/login.do")
                .loginProcessingUrl("/loginById.do")
                .usernameParameter("eName")             // 매개변수랑 일치
                .passwordParameter("ePassword")         // 매개변수랑 일치
                .defaultSuccessUrl("/")
                .failureForwardUrl("/login.do");

        // 로그아웃 설정
        http.logout()
                .logoutUrl("/logout.do")
                .logoutSuccessUrl("/");

        /* // 메소드 체이닝 방법
        http.csrf().disable().cors().disable()              // 공통 접근 설정
                .authorizeHttpRequests()
                .requestMatchers("/", "login.do", "join.do").permitAll()    // 열거 순서 중요 - permitAll() : 모든 사람 접근 가능
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .requestMatchers("/emp/**").hasAnyRole("ADMIN", "EMP")
                .anyRequest().authenticated()

                .and().formLogin()                          // 로그인 설정
                    .loginPage("/login.do")
                    .loginProcessingUrl("/loginById.do")
                    .usernameParameter("eName")             // 매개변수랑 일치
                    .passwordParameter("ePassword")         // 매개변수랑 일치
                    .defaultSuccessUrl("/")
                    .failureForwardUrl("/login.do")

                .and().logout()                             // 로그아웃 설정
                    .logoutUrl("/logout.do")
                    .logoutSuccessUrl("/");
         */

        return http.build();
                
    } 
    
}
