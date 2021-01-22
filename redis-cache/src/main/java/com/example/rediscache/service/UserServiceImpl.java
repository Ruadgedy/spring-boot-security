package com.example.rediscache.service;

import com.example.rediscache.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhao
 * @date: 2021/1/21
 * @description:
 */
// !使用SpringCache一定要设置cacheName，有两种方式:
// !    第一种：@CacheConfig(cacheNames="")
// !    第二种：@CachePut(value=""), @Cacheable(value="), @CacheEvict(value=")
@Service
@CacheConfig(cacheNames = "c1")
public class UserServiceImpl implements UserService {

    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    static {
        USER_MAP.put(1, new User(1, "小明"));
        USER_MAP.put(2, new User(2, "屁屁婧"));
        USER_MAP.put(3, new User(3, "小小豪"));
    }

    @CachePut(key = "#user.id")
    @Override
    public User save(User user) {
        USER_MAP.put(user.getId(), user);
        System.out.println("进入save方法，当前存储对象: " + user);
        return user;
    }

    @Cacheable(key = "#id")
    @Override
    public User get(Integer id) {
        final User user = USER_MAP.get(id);
        System.out.println("进入get方法，当前存储对象为：" + user);
        return user;
    }

    @CacheEvict(key = "#id")
    @Override
    public void delete(Integer id) {
        USER_MAP.remove(id);
        System.out.println("进入delete方法，删除成功");
    }
}
