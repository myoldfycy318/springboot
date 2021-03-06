package com.learn.demo.dao;

import com.learn.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserMapper {

    void insert(User user);

    User selectById(Integer id);

    List<User> queryUsers();

    int saveSendHist(Map<String,String> map);

}
