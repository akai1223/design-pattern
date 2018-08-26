package com.zek.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/8/25 下午1:50
 */
@SpringCloudApplication
public class UserServiceProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootstrap.class, args);
    }
}
