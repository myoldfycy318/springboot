package com.learn.demo.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by shanmin.zhang
 * Date: 18/5/11
 * Time: 下午2:39
 */
public class ApplicationUtil implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    private static ApplicationContext context;
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    //加载开发者信息到redis
}
