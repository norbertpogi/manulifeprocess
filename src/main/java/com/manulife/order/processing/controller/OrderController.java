package com.manulife.order.processing.controller;

import com.manulife.order.processing.model.CustomerOrder;
import com.manulife.order.processing.repository.OrderRepository;
import com.manulife.order.processing.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder savedCustomerOrder = orderRepository.save(customerOrder);
        kafkaProducerService.publishOrder(savedCustomerOrder);
        return ResponseEntity.ok(savedCustomerOrder);
    }
}
