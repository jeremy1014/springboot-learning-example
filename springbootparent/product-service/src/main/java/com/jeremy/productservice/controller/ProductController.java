package com.jeremy.productservice.controller;


import dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/prod")
public class ProductController {

    @Value("${server.port}")
    String port;

    @Value("${eureka.instance.instance-id}")
    String instance_id;

    @GetMapping("/list")
    ResponseEntity<List<Product>> list() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("001", "shoes", "nike", 299));
        products.add(new Product("002", "cloth", "addidas", 399));
        products.add(new Product("003", "paints", "nike", 199));

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/ping")
    ResponseEntity<String> ping() {
        return new ResponseEntity<>(instance_id, HttpStatus.OK);
    }
}
