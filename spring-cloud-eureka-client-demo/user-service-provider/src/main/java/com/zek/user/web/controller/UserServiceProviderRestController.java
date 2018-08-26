package com.zek.user.web.controller;

import com.zek.user.domain.User;
import com.zek.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/8/25 下午1:46
 */
@RestController
public class UserServiceProviderRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userService.save(user)) {
            return user;
        } else {
            return null;
        }
    }

    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }

}
