package com.hlj.service;

import com.hlj.dao.TIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-14.
 */
@Service
public class RedisServiceImpl {

    @Autowired
    private Jedis jedis;

    @Autowired
    private TIRepository tiRepository;

    public void ping() {
        System.out.println(jedis.ping());
        Pageable pageable = new PageRequest(100,20, Sort.Direction.DESC, "a");
        System.out.println(tiRepository.findByPage(pageable));
    }
}
