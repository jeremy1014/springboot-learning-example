package com.jeremy.rest.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    ResponseEntity<String> hello(String word) {

        return new ResponseEntity<>("The port is " + port, HttpStatus.OK);
    }
}
