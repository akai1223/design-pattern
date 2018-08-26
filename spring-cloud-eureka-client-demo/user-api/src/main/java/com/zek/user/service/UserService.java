package com.zek.user.service;

import com.zek.user.domain.User;

import java.util.Collection;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/8/25 下午1:11
 */
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    boolean save(User user);

    Collection<User> findAll();
}
