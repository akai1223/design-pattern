package com.zek.mongodbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author zhangkai
 * @date 2019-06-13 21:00
 */
@RestController
public class MongoDbDemoController {


    @Autowired
    private MongoTemplate mongoTemplate;


}
