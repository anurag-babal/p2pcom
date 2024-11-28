package com.example.p2pcom.service;

import com.example.p2pcom.data.SubscriberRepository;
import com.example.p2pcom.model.Subscriber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Subscriber addSubscriber(String userId, String category) {
        var subscriber = new Subscriber();
        subscriber.setUserId(userId);
        subscriber.setCategory(category);
        subscriberRepository.addSubscriber(subscriber);
        return subscriber;
    }

    public List<String> getSubscribers(String category) {
        return subscriberRepository.getSubscribers(category);
    }
}
