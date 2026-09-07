package com.practice.e_commerce.controller;

import java.util.List;
import com.practice.e_commerce.entity.Order;
import com.practice.e_commerce.dto.OrderRequest;
import com.practice.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {

        return orderService.placeOrder(request);

    }
    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Integer userId) {
        return orderService.getOrders(userId);
    }
}