package com.hlj.controller;

import com.google.common.collect.Sets;
import com.hlj.common.dtos.response.Response;
import com.hlj.common.utils.RedisUtil;
import com.hlj.common.utils.ResponseUtil;
import com.hlj.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@RestController
public class PingController {

    private static final String KEY = "hlj::list";
    private static AtomicInteger count = new AtomicInteger(1);

    @Resource
    private PingService pingService;

    @GetMapping(value = "/ping")
    @ResponseBody
    public Response ping() throws TException {
        return ResponseUtil.success(pingService.ping());
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public Response<String> get() {
        Jedis jedis = RedisUtil.getJedis();
        String value = null;
        try {
            value = RedisUtil.getJedis().rpop(KEY);
        } catch (Exception e) {
            RedisUtil.returnBrokenResource(jedis);
        } finally {
            RedisUtil.returnResource(jedis);
        }
        return ResponseUtil.success(value);
    }

    public static void main(String[] args) throws Exception {
        push();
//        pop();
    }

    public static void push() {
        Set<String> list = Sets.newHashSet();
        for (int i = 0; i < 100000; i++) {
            list.add(String.valueOf(i));
        }
        for (String s : list) {
            RedisUtil.getJedis().lpush(KEY, s);
        }
    }

    public static void pop() {
        ExecutorService exec = Executors.newFixedThreadPool(30);
        for (int index = 0; index < 500; index++) {
            final int NO = index;
            exec.execute(() -> {
                try {
                    System.out.println(count.getAndIncrement());
                    Thread.sleep(new Random().nextInt(1000));
                    long time1 = System.currentTimeMillis();
                    URL url = new URL("http://localhost:8080/get");
                    InputStreamReader isr = new InputStreamReader(url.openStream());
                    long time2 = System.currentTimeMillis();
                    BufferedReader br = new BufferedReader(isr);
                    String str;
                    while ((str = br.readLine()) != null) {
                        System.out.println("Thread " + NO + " time:" + (time2 - time1) + "ms" + "=" + str);
                    }
                    br.close();
                    isr.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}