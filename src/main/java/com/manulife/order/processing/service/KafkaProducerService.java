package com.manulife.order.processing.service;

import com.manulife.order.processing.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishOrder(CustomerOrder order) {
        kafkaTemplate.send(TOPIC, order);
    }
}
