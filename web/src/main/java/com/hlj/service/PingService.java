package com.hlj.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hlj.common.api.PingAPI;
import com.hlj.common.dtos.response.Response;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class PingService {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private RPCService rpcService;

    public String rpc() {
        return rpcService.ping();
    }

    private static AtomicInteger count = new AtomicInteger(1);

    public static void retrofit() throws Exception {
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

    public static void call() {
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