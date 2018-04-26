package com.learn.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testrdids() {
        //设置缓存，建议每个键都设置过期时间
        redisTemplate.opsForValue().set("testxx", "test", 10, TimeUnit.MINUTES);
        //获取缓存值
        String value = redisTemplate.opsForValue().get("test");

        System.out.println(value);

        //删除某个键
        //redisTemplate.delete("test");

        //操作set
        redisTemplate.opsForSet().add("testSet", "1");
        Set<String> members = redisTemplate.opsForSet().members("testSet");//获取set内的所有值
        //redisTemplate.opsForSet().remove("testSet", "1","2");//移除set内的多个对象

        System.out.println(members);

        //操作list
        redisTemplate.opsForList().rightPush("testList", "1");
        List<String> list = redisTemplate.opsForList().range("testList", 0, -1);//获取list内的所有元素
        System.out.println(list);

    }

}
