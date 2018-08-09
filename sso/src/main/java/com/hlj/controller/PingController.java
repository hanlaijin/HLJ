package com.hlj.controller;

import com.hlj.common.api.PingAPI;
import com.hlj.common.dtos.PingRequest;
import com.hlj.common.dtos.response.Response;
import com.hlj.common.utils.RedisUtil;
import com.hlj.common.utils.ResponseUtil;
import com.hlj.service.PingService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@RestController
public class PingController {

    private static AtomicInteger count = new AtomicInteger(1);

    @Resource
    private PingService pingService;

    @GetMapping(value = "/ping")
    @ResponseBody
    public Response ping() throws TException {
        return ResponseUtil.success(pingService.ping("mac"));
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    @ResponseBody
    public Response<String> get(HttpServletRequest request, PingRequest ping) throws Exception {
//        PingRequest ping = RequestUtil.getRequestDto(request, PingRequest.class);
        log.info("ping request = {}", ping);
        String value = pingService.get("hlj::queue");
        return ResponseUtil.success(value);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Jedis jedis = RedisUtil.getJedis();
            System.out.println(jedis.rpop("hlj::list"));
            RedisUtil.returnBrokenResource(jedis);
        }
//        send2();
//        push();
//        pop();
    }

    public static void send() throws Exception {
//        PingAPI realSubject = new RestAdapter.Builder()
//                .setEndpoint("https://api.weixin.qq.com")
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setLog(new RestAdapter.Log() {
//                    @Override
//                    public void log(String message) {
//                        log.info(message);
//                    }
//                })
//                .build().create(PingAPI.class);
    }

    public static void send2() throws Exception {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        PingAPI pingAPI = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(PingAPI.class);
        Call<Response> call = pingAPI.ping("fk1", "fk2", 3L);
        Response response = call.execute().body();
        System.out.println(response);
    }

    public static void push() {
        for (int i = 0; i < 5000; i++) {
            Jedis jedis = RedisUtil.getJedis();
            jedis.lpush("hlj::queue", String.valueOf(i));
//            jedis.setex("hlj::" + i, 600, "what" + i);
            RedisUtil.returnBrokenResource(jedis);
        }
    }

    public static void pop() {
        ExecutorService exec = Executors.newFixedThreadPool(50);
        for (int index = 0; index < 5000; index++) {
            final int NO = index;
            exec.execute(() -> {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                    long time1 = System.currentTimeMillis();
                    URL url = new URL("http://localhost:8080/get?k1=" + count.getAndIncrement());
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