package com.zek.user.repository;

import com.zek.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Auther zhangkai
 * @DateTime 2018/8/25 下午1:32
 */
@Repository
public class UserRepository {

    private ConcurrentHashMap<Long, User> repository = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);

    public Collection<User> findAll() {
        return repository.values();
    }

    public boolean save(User user) {

        Long id = idGenerator.incrementAndGet();

        user.setId(id);
        return repository.putIfAbsent(id, user) == null;
    }
}
