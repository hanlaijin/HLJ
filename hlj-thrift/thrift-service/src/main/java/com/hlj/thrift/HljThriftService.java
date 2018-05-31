package com.hlj.thrift;

import com.facebook.swift.codec.ThriftField;
import com.hlj.common.utils.RedisUtil;
import com.hlj.thrift.common.CallbackFuture;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class HljThriftService implements HljService.Async {


    @Override
    public CallbackFuture<String> ping() {
        CallbackFuture<String> result = new CallbackFuture<String>();
        return result;
    }

    @Override
    public CallbackFuture<User> getUserFromDB(@ThriftField(value = 1, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) {
        CallbackFuture<User> result = new CallbackFuture<User>();

        return result;
    }

    @Override
    public CallbackFuture<String> getFromQueue(@ThriftField(value = 1, name = "key", requiredness = ThriftField.Requiredness.NONE) String key) {
        CallbackFuture<String> result = new CallbackFuture<String>();
        Jedis jedis = RedisUtil.getJedis();
        result.set(jedis.rpop(key));
        RedisUtil.returnBrokenResource(jedis);
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