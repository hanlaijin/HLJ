package com.hlj.common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-24.
 */
public class RedisUtil {

    private static Object mutex = new Object();
    private static JedisPool pool = null;

    static {
        if (pool == null) {
            synchronized (mutex) {
                if (pool == null) {
                    initPool();
                }
            }
        }
    }

    public static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
//        config.setMaxWaitMillis(REDIS_TIME_OUT);
        config.setTestOnBorrow(false);
        config.setTestWhileIdle(true);
        config.setTimeBetweenEvictionRunsMillis(300000);
        config.setMinEvictableIdleTimeMillis(1800000);
        config.setNumTestsPerEvictionRun(-1);
        pool = new JedisPool(config, "127.0.0.1", 6379);
    }

    public static void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }
}
