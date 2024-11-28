package com.example.p2pcom.service;

import com.example.p2pcom.constants.AppConstants;
import com.example.p2pcom.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final SubscriberService subscriberService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public NotificationService(
            SubscriberService subscriberService,
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.subscriberService = subscriberService;
    }

    @KafkaListener(topics = AppConstants.PRODUCT_LISTING_TOPIC)
    public void sendNotification(Product product) {
        System.out.println("Received product: " + product.getCategory());
        var users = subscriberService.getSubscribers(product.getCategory());
        for (String user : users) {
            String message = createNotificationMessage(user, product);
            kafkaTemplate.send(AppConstants.USER_NOTIFICATION_TOPIC, message);
        }
    }

    private String createNotificationMessage(String user, Product product) {
        return "Hello " + user + ",\n" +
                "A new product in category " + product.getCategory() + " is available.\n" +
                "Product details: " + product.getName() + ", " + product.getPrice();
    }
}
