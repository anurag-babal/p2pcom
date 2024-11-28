package com.example.p2pcom.config;

import com.example.p2pcom.constants.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(AppConstants.PRODUCT_LISTING_TOPIC)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name(AppConstants.USER_SUBSCRIPTION_TOPIC)
                .build();
    }

    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name(AppConstants.USER_NOTIFICATION_TOPIC)
                .build();
    }
}
