package com.zek.customer.enable.autoconfig.enableconfig;

import com.zek.customer.enable.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/11/27 10:28 PM
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    private User user;

    @GetMapping("/user/find")
    public String find(){

        log.info("user {}", user.getName() + " | " + user.getAge());

        return user.getName() + " | " + user.getAge();
    }
}
