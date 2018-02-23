package com.learn.demo.service;

import com.learn.demo.entity.User;

import java.util.List;

public interface UserService {

   void insert(User user);

   User selectById(Integer id);

   List<User> queryUsers(Integer pageNum, Integer pageSize);
}
