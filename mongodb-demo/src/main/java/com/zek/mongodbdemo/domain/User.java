package com.zek.mongodbdemo.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zhangkai
 * @description
 * @date 2019-06-14 17:53
 */
@Data
@Document(collection = "test")
public class User {

    private String id;

    private String name;

    private Integer age;
}
