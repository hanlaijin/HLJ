package com.hlj.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hlj.common.filter.TestFilter;
import com.hlj.common.interceptor.TestAsyncInterceptor;
import com.hlj.common.interceptor.TestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-9.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new TestInterceptor();
    }

    @Bean
    public HandlerInterceptor getMyAsyncInterceptor() {
        return new TestAsyncInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(getMyAsyncInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    // 注册filter
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("TestFilter");
        registration.setOrder(1);
        return registration;
    }

    // dubbo
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-client");
        return applicationConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
//        registryConfig.setClient("curator");
        return registryConfig;
    }
}
