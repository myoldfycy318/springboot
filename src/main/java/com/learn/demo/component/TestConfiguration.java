package com.learn.demo.component;


import com.learn.demo.entity.TestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {


    @Bean
    public TestConfig testConfig(){
        return new TestConfig();
    }

}
