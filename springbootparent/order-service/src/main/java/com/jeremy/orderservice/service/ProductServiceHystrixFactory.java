package com.jeremy.orderservice.service;

import dto.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class ProductServiceHystrixFactory implements FallbackFactory<ProductService> {

    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {

            @Override
            public List<Product> findAll() {
                return null;
            }

            @Override
            public String ping() {
                return MessageFormat.format("this is ProductServiceHystrix {0}", throwable.toString());
            }
        };
    }
}
