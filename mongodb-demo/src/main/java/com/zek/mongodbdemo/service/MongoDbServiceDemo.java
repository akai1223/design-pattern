package com.zek.mongodbdemo.service;

import com.zek.mongodbdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangkai
 * @description
 * @date 2019-06-14 17:52
 */
@Service
public class MongoDbServiceDemo {

    private static final String collectionName = "test";

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(User user) {
        mongoTemplate.save(user);
    }

    public List<User> findAll() {
        return mongoTemplate.findAll(User.class, collectionName);
    }
}
