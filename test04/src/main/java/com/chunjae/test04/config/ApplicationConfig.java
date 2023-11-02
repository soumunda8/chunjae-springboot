package com.chunjae.test04.config;

import com.chunjae.test04.biz.UserService;
import com.chunjae.test04.biz.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.chunjae.test04")
public class ApplicationConfig {

    @Bean
    public UserService userService() {return new UserServiceImpl();}

}