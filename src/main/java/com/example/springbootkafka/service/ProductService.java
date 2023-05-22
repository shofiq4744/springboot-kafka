package com.example.springbootkafka.service;

import com.example.springbootkafka.producers.ProductProducer;
import com.example.springbootkafka.requests.Product;
import com.example.springbootkafka.requests.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    private ProductProducer productProducer;

    @Autowired
    public ProductService(ProductProducer productProducer) {
        this.productProducer = productProducer;
    }

    public void sendMessage(ProductMessage message) {
        log.info("[ProductService] send product to topic");
        productProducer.send(message);
    }

}
