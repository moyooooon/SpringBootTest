package com.example;

import com.example.demo.handler.LogIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.MappedInterceptor;

@SpringBootApplication
public class SpringtestApplication {

    @Autowired
    private LogIntercepter logIntercepter;

    //register intercepter

    @Bean
    public MappedInterceptor accessInterceptor() {
        return new MappedInterceptor(new String[] {"/*"},
                logIntercepter);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringtestApplication.class, args);
    }

}
