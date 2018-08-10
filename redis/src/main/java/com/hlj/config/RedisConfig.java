package com.hlj.config;

import com.hlj.client.RedisFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-10.
 */
@Configuration
public class RedisConfig {

    @Bean
    public Jedis getJedis() {
        return RedisFactory.getJedis();
    }
}
