package com.hlj;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.hlj.service")
public class RPCApplication {

	public static void main(String[] args) {
		SpringApplication.run(RPCApplication.class, args);
	}
}
