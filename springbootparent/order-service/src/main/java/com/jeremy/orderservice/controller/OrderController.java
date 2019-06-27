package com.jeremy.orderservice.controller;


import com.jeremy.orderservice.service.OrderService;
import com.jeremy.orderservice.service.ProductService;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> all() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>(productService.ping(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public String find() {
        return orderService.getName();
    }

    @GetMapping("/ping2")
    public ResponseEntity<String> ping2() {

        try {
            return new ResponseEntity<>(restTemplate.getForObject("http://localhost:9001/prod/ping", String.class), HttpStatus.OK);
        }
        catch (Exception exp)
        {
            return new ResponseEntity<>(exp.getMessage(), HttpStatus.OK);
        }
    }
}
