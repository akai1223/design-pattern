package com.zek.mongodbdemo.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.zek.mongodbdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    /**
     * 功能描述: mongodb新增数据
     *
     * @author zhangkai
     * @date 2019-06-14
     * @param user
     * @return void
     */
    public void save(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 功能描述: mongodb 查询所有数据
     *
     * @author zhangkai
     * @date 2019-06-14
     * @param
     * @return java.util.List<com.zek.mongodbdemo.domain.User>
     */
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class, collectionName);
    }


    /**
     * 功能描述: mongodb 条件查询
     *
     * @author zhangkai
     * @date 2019-06-14
     * @param name
     * @return java.util.List<com.zek.mongodbdemo.domain.User>
     */

    public List<User> query(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        List<User> list = mongoTemplate.find(query, User.class);
        return list;
    }

    /**
     * 功能描述: mongodb 更新
     *
     * @author zhangkai
     * @date 2019-06-14
     * @param user
     * @return void
     */
    public void update(User user) {
        Query query = Query.query(Criteria.where("name").is(user.getName()));
        Update update = Update.update("age", user.getAge());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, collectionName);
        updateResult.getModifiedCount();
    }

    /**
     * 功能描述: mongodb 删除
     *
     * @author zhangkai
     * @date 2019-06-14
     * @param name
     * @return void
     */
    public void delete(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        DeleteResult deleteResult = mongoTemplate.remove(query, collectionName);
        deleteResult.getDeletedCount();
    }
}
