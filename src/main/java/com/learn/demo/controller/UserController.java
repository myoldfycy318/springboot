package com.learn.demo.controller;

import com.learn.demo.common.exception.ResultException;
import com.learn.demo.entity.User;
import com.learn.demo.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("/adduser")
    public String addUser(User user) {
        userService.insert(user);
        return "ok";
    }

    @GetMapping("/findUser")
    public User findUser(){
        return userService.selectById(1);
    }


    @PostMapping("/valid")
    public void testValid(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ResultException(100,bindingResult.getFieldError().getDefaultMessage());
        }
        userService.insert(user);
    }

    @GetMapping("/findUsers")
    public User findUsers(){
        return userService.selectById(1);
    }




}
