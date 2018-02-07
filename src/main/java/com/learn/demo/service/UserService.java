package com.learn.demo.service;

import com.learn.demo.entity.User;

public interface UserService {

   void insert(User user);

   User selectById(Integer id);
}
