package com.hlj;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.hlj.service.PingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.hlj.service")
public class HljWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HljWebApplication.class, args);
	}
}
