package com.manulife.order.processing.controller;

import com.manulife.order.processing.model.CustomerOrder;
import com.manulife.order.processing.repository.OrderRepository;
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

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder customerOrder) {
        CustomerOrder savedCustomerOrder = orderRepository.save(customerOrder);
        return ResponseEntity.ok(savedCustomerOrder);
    }
}
