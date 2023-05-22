package com.example.springbootkafka.listeners;

import com.example.springbootkafka.requests.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductListener {
    @KafkaListener(topics = "product", containerFactory = "kafkaListenerContainerFactory")
    public void newProductListener(ProductMessage product) {
        log.info("Get request from product topic " + product.toString());
    }
}
