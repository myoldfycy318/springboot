package com.learn.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.demo.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUsers() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user/findUser")).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 使用数据库自增获取自增数据(){
        Map<String,String>  map = new HashMap<>();
        int result = userMapper.saveSendHist(map);
        System.out.println(result);
        System.out.println(JSONObject.toJSONString(map));
    }
}