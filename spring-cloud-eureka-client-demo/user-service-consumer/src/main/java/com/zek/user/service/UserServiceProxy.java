package com.zek.user.service;

import com.zek.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/9/2 下午11:49
 */
@Service
public class UserServiceProxy implements UserService {

    private static  final String provider_server_url_prefix="http://user-service-provider";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public boolean save(User user) {

        User user1 = restTemplate.postForObject(provider_server_url_prefix + "/user/save", user, User.class);
        return user1 != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(provider_server_url_prefix + "user/list", Collection.class);
    }
}
