package com.learn.demo.controller;

import com.learn.demo.component.mq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQController {

    @Autowired
    private Producer producer;


    @Test
    public void test1() throws InterruptedException {
        producer.sendMsg("xxx.....");
        System.out.println("----->结束------");
        Thread.sleep(50000);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void 非confirm(){

    }
}
