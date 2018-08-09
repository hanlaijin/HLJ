package com.hlj.thrift;

import com.facebook.swift.codec.ThriftField;
import com.hlj.common.utils.RedisUtil;
import com.hlj.thrift.common.CallbackFuture;
import com.hlj.thrift.dao.TI;
import com.hlj.thrift.dao.TIRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class HljThriftService implements HljService.Async {

    @Autowired
    public TIRepository tiRepository;

    @Override
    public CallbackFuture<String> ping() {
        CallbackFuture<String> result = new CallbackFuture<String>();
        int count = 0;
        List<TI> list = new LinkedList<>();
        for (int i=0;i<100000000;i++) {
            TI ti = new TI(i, i);
            list.add(ti);
            if (count++ == 10000) {
                log.info("10000");
                count = 0;
                tiRepository.saveAll(list);
                list.clear();
            }
        }
        result.set("success");
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