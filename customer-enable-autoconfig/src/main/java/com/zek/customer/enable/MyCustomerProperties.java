package com.zek.customer.enable;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/11/27 10:13 PM
 */
@ConfigurationProperties(prefix = "my.customer")
public class MyCustomerProperties {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
