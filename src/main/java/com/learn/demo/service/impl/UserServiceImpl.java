package com.learn.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.learn.demo.dao.UserMapper;
import com.learn.demo.entity.User;
import com.learn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void insert(User user) {
        userMapper.insert(user);
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.opsForValue().set("springboot1","事物回滚？");
//        int i = 1 / 0;
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> queryUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.queryUsers();
    }
}
