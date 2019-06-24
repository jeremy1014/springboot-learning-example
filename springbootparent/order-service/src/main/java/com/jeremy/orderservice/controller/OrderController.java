package com.jeremy.orderservice.controller;


import com.jeremy.orderservice.service.OrderService;
import com.jeremy.orderservice.service.ProductService;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

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
//        return "Success!";
    }

//    public String hiError(Throwable e) {
//        return "this is fallback by Hystrix";
////        return new ResponseEntity<>("this is fallback by Hystrix", HttpStatus.OK);
//    }
}
