package com.learn.springboot.service.impl;

import com.learn.springboot.dao.UserDao;
import com.learn.springboot.entity.User;
import com.learn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
