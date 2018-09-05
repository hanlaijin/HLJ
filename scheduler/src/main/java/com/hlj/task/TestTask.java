package com.hlj.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-13.
 */
@Component
@PropertySource(value = {"classpath:task.properties"})
public class TestTask {

    @Autowired
    private Environment env;

    @Value("${com.hlj.count}")
    private int count;

    //每秒进行一次操作
    @Scheduled(cron="*/1 * * * * ?")
    private void test() {
        System.out.println("run scheduler "+ count++);
    }

    //每2000ms进行一次操作
    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {
        String count = env.getProperty("com.hlj.task.count");
        System.out.println(count + "现在时间：" + new Date());
    }

}
