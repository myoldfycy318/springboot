package com.learn.demo.dao;

import com.learn.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    void insert(User user);

    User selectById(Integer id);

    List<User> queryUsers();
}
