package com.jeremy.orderservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    static Integer count = 3;

    @HystrixCommand(
            fallbackMethod = "fallbackMethod",
            commandProperties = {
                    // 熔断器在整个统计时间内是否开启的阀值
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "1"),
                    // 至少有3个请求才进行熔断错误比率计算
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")},
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "5"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public String getName() {
        log.warn("getName");
        count--;
        int i = 1 / count;
        return "Hello  getName";
    }

    public String fallbackMethod() {
        return "this is fallback by Hystrix";
    }
}
