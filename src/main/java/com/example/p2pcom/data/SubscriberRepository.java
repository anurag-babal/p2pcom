package com.example.p2pcom.data;

import com.example.p2pcom.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscriberRepository {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public List<String> getSubscribers(String category) {
        List<String> users = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCategory().equals(category)) {
                users.add(subscriber.getEmail());
            }
        }
        return users;
    }
}
