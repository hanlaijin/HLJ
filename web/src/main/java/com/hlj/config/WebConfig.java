package com.hlj.config;

import com.hlj.common.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-9.
 */
@Configuration
public class WebConfig {

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
}
