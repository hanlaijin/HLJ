package com.hlj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-10.
 */
@Service
public class RedisService {

    @Autowired
    private Jedis jedis;

    public void ping() {
        System.out.println(jedis.ping());
    }
}
