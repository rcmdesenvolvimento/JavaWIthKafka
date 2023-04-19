package com.rcm.sistemas.car.analytics.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rcm.sistemas.car.analytics.dto.CarPostDTO;
import com.rcm.sistemas.car.analytics.service.PostAnalyticsService;

@Component
public class KafkaConsumerMessage {
	
	private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
	
    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(@Payload CarPostDTO carPost) {

        System.out.println("Received Car Post information : " + carPost);
        LOG.info("ANALYTICS DATA - Received Car Post information: {}", carPost);
        
        postAnalyticsService.saveDataAnalytics(carPost);

    }


}
