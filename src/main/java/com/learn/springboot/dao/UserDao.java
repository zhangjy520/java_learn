package com.learn.springboot.dao;

import com.learn.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(User user){
        String sql = "insert into t_user(user_name, password) values(?,?)";
        jdbcTemplate.update(sql,user.getUserName(),user.getPassword());
    }
}
