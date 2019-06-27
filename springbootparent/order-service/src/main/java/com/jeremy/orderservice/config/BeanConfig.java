package com.jeremy.orderservice.config;

import com.jeremy.base.filter.RequestLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public FilterRegistrationBean<RequestLogFilter> testFilterRegistration() {
        FilterRegistrationBean<RequestLogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestLogFilter());
        registration.addUrlPatterns("/*");//配置过滤路径
        registration.setName("RequestLogFilter");//设置filter名称
        registration.setOrder(1);//请求中过滤器执行的先后顺序，值越小越先执行
        return registration;
    }
}
