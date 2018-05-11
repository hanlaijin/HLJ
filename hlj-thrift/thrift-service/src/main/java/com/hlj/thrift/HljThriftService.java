package com.hlj.thrift;

import com.facebook.swift.codec.ThriftField;
import com.google.common.collect.Sets;
import com.hlj.common.dtos.thrift.CallbackFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HljThriftService implements HljService.Async {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public CallbackFuture<String> ping() {
        CallbackFuture<String> result = new CallbackFuture<String>();
        try {
            Set<String> list = Sets.newHashSet();
            for (int i = 0; i < 100; i++) {
                list.add(String.valueOf(i));
            }
            for (String s : list) {
                redisTemplate.opsForList().leftPush("hlj::list", s);
            }
            result.set("pong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CallbackFuture<User> getUserFromDB(@ThriftField(value = 1, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) {
        CallbackFuture<User> result = new CallbackFuture<User>();

        return result;
    }

    @Override
    public CallbackFuture<String> getFromRedis(@ThriftField(value = 1, name = "key", requiredness = ThriftField.Requiredness.NONE) String key) {
        CallbackFuture<String> result = new CallbackFuture<String>();

        return result;
    }

    @Override
    public CallbackFuture<Boolean> saveUserToRedis(@ThriftField(value = 1, name = "user", requiredness = ThriftField.Requiredness.NONE) User user) {
        CallbackFuture<Boolean> result = new CallbackFuture<Boolean>();

        return result;
    }

    @Override
    public CallbackFuture<User> getUserFromRedis(@ThriftField(value = 1, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) {
        CallbackFuture<User> result = new CallbackFuture<User>();

        return result;
    }
}