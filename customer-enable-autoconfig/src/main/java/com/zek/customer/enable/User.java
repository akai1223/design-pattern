package com.zek.customer.enable;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/11/27 10:03 PM
 */
public class User {

    private MyCustomerProperties myCustomerProperties;

    public User(){

    }


    public User(MyCustomerProperties myCustomerProperties) {
        this.myCustomerProperties = myCustomerProperties;
        this.setName(this.myCustomerProperties.getName());
        this.setAge(this.myCustomerProperties.getAge());
    }

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
