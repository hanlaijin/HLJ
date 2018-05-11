package com.hlj.thrift;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HljSpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HljSpringbootApplication.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        System.out.println("所以beanNames个数：" + beanNames.length);
        for (String bn : beanNames) {
            System.out.println(bn);
        }
    }

    @Bean
    public CommandLineRunner startThrift() {
        return new ThriftServerFactory();
    }
}
