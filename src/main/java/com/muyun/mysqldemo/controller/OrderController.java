package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.entity.Order;
import com.muyun.mysqldemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @GetMapping(params = "createdBy")
    public List<Order> findAllByCreatedBy(@RequestParam Long createdBy) {
        return orderRepository.findAllByCreatedBy(createdBy);
    }


    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return orderRepository.findById(id);
    }

    @GetMapping(path = "/{id}", params = "createdBy")
    public Optional<Order> findById(@PathVariable Long id, @RequestParam Long createdBy) {
        orderRepository.findByIdAndCreatedByAndOrderItemsOrderId(id, createdBy);
        orderRepository.findByIdAndCreatedByAndOrderItems_OrderId(id, createdBy, id);

        return orderRepository.findByIdAndCreatedBy(id, createdBy);
    }


    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderRepository.save(order);
    }


}
