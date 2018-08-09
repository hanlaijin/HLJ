package com.hlj.service;

import com.hlj.aop.AN;
import com.hlj.common.utils.RedisUtil;
import com.hlj.thrift.HljService;
import com.hlj.thrift.common.ThriftClientFactory;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class PingService {

    public static HljService service = ThriftClientFactory.createThriftClient(HljService.class);

    @AN
    public String ping(String mac) throws TException {
        return service.ping();
    }

    public String get(String key) throws TException {
        Jedis jedis = RedisUtil.getJedis();
        String result = jedis.rpop(key);
        RedisUtil.returnBrokenResource(jedis);
        return result;
    }
}