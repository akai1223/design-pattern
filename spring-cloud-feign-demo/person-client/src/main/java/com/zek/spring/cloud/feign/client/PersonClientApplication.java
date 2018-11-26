package com.zek.spring.cloud.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/24 下午7:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.zek.spring.cloud.feign")
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);

    }
}
