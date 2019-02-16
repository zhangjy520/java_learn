package com.learn.springboot.controller;

import com.learn.springboot.entity.User;
import com.learn.springboot.util.MongoBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {

    @Autowired
    MongoBaseDao mongoBaseDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/hello")
    public String sayHello(){
     /*   Criteria sql1 = Criteria.where("values.b92").is("bbbbb92");
        Query query = new Query(new Criteria().orOperator(sql1));
        List<Object> res = mongoBaseDao.getRecords(query,Object.class,"test");
        System.out.println("sss");

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUserName(""+i+"");
            user.setPassword(""+i+"");
            userList.add(user);

        }*/

        GroupByResults<Object> s = mongoTemplate.group(null, "test", new GroupBy("GroupField"), Object.class);

//        mongoBaseDao.addMongDataByList(userList,"test");
        System.out.println("ssssss");
        return "hello,spring boot";
    }
}
