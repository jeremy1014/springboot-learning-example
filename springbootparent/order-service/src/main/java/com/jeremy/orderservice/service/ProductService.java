package com.jeremy.orderservice.service;

import dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "PRODUCT-SERVICE",fallbackFactory = ProductServiceHystrixFactory.class)
public interface ProductService {

    @RequestMapping(value = "/prod/list", method = RequestMethod.GET)
    List<Product> findAll();

    @RequestMapping(value = "/prod/ping", method = RequestMethod.GET)
    String ping();

//    @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
//    Product loadByItemCode(@PathVariable("itemCode") String itemCode);

}
