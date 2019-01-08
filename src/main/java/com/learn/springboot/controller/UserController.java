package com.learn.springboot.controller;

import com.learn.springboot.entity.User;
import com.learn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        service.save(user);
        System.out.println("sssDDDDDSADASDDDDDD");

        return "save user successful";
    }

    @RequestMapping("/saveUsera")
    public String saveUsera(User user){
        service.save(user);
        return "save user successful";
    }
}
