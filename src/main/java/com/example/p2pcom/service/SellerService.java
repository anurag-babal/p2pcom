package com.example.p2pcom.service;

import com.example.p2pcom.constants.AppConstants;
import com.example.p2pcom.model.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    private final KafkaTemplate<String, Product> kafkaTemplate;

    public SellerService(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void listProduct(Product product) {
        var future = kafkaTemplate.send(AppConstants.PRODUCT_LISTING_TOPIC, product);
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Sent product with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send product due to : " + exception.getMessage());
            }
        });
    }
}
