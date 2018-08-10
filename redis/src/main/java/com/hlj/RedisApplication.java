package com.hlj;

import com.hlj.service.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RedisApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		System.out.println("所有beanNames个数：" + beanNames.length);
		for (String bn : beanNames) {
			System.out.println(bn);
		}
		RedisService service = ctx.getBean(RedisService.class);
		service.ping();
	}
}
