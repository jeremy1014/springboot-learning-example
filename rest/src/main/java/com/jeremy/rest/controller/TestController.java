package com.jeremy.rest.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    ResponseEntity<String> wrap(String word) {
        return new ResponseEntity<>("hello world!!", HttpStatus.OK);
    }
}
