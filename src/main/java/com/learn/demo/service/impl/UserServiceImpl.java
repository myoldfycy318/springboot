package com.learn.demo.service.impl;

import com.learn.demo.dao.UserMapper;
import com.learn.demo.entity.User;
import com.learn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }
}
