package com.jeremy.webflux.controller;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


import java.util.List;

@RestController
public class CityController {

    @GetMapping("/hello2")
    public Mono<String> hello() {   // 【改】返回类型为Mono<String>

        List<String> strs = Lists.newArrayList("a","b");
        return Mono.just("Welcome to reactive world ~");     // 【改】使用Mono.just生成响应式数据
    }

}
