package com.example.p2pcom.service;

import com.example.p2pcom.constants.AppConstants;
import com.example.p2pcom.model.Subscriber;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuyerService {
    private final SubscriberService subscriberService;

    public BuyerService(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @KafkaListener(
            topics = AppConstants.USER_NOTIFICATION_TOPIC,
            groupId = AppConstants.NOTIFICATION_GROUP,
            containerFactory = "kafkaListenerContainerFactoryString"
    )
    public void getNotification(String notification) {
        System.out.println("Received notification: " + notification);
    }

    public Subscriber subscribe(String category) {
        return subscriberService.addSubscriber(UUID.randomUUID().toString(), category);
    }
}
