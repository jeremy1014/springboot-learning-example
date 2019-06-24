package com.jeremy.orderservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    static Integer count = 3;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getName() {
        count--;
        int i = 1 / count;
        return "Hello  getName";
    }

    public String fallbackMethod() {
        return "this is fallback by Hystrix";
    }
}
