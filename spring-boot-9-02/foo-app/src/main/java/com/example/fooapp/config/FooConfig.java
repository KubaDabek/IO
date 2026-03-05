package com.example.fooapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfig {

    @Bean
    String bar() {return "bar";}
}
