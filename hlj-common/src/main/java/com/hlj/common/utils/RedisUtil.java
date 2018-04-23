package com.hlj.common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hanlaijin@xiaomi.com on 18-4-23.
 */
public class RedisUtil {
    //Redis服务器IP
    private static String HOST = "127.0.0.1";

    //Redis的端口号
    private static int PORT = 6379;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 500;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 100;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10 * 1000;

    private static int TIMEOUT = 10 * 1000;//超时时间

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);//使用时进行扫描，确保都可用
        config.setTestWhileIdle(true);//Idle时进行连接扫描
        config.setTestOnReturn(true);//还回线程池时进行扫描
//            表示idle object evitor两次扫描之间要sleep的毫秒数
//            config.setTimeBetweenEvictionRunsMillis(30000);
//            表示idle object evitor每次扫描的最多的对象数
//            config.setNumTestsPerEvictionRun(10);
//            表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
//            config.setMinEvictableIdleTimeMillis(60000);
        jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT);
    }
    public static synchronized Jedis getJedis() {
        Jedis jedis = null;
        if (jedisPool != null) {
            try {
                if (jedis == null) {
                    jedis = jedisPool.getResource();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jedis;
    }

    /**
     * 回收Jedis对象资源
     *
     * @param jedis
     */
    public static synchronized void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * Jedis对象出异常的时候，回收Jedis对象资源
     *
     * @param jedis
     */
    public static synchronized void returnBrokenResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnBrokenResource(jedis);
        }

    }
}
