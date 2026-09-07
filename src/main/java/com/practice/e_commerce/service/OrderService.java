package com.practice.e_commerce.service;

import com.practice.e_commerce.dto.OrderRequest;
import com.practice.e_commerce.entity.*;
import com.practice.e_commerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public String placeOrder(OrderRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        List<CartItem> cartItems = cartItemRepository.findByCart(cart);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is Empty");
        }

        double totalAmount = 0;

        for (CartItem item : cartItems) {
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(totalAmount);

        order = orderRepository.save(order);

        for (CartItem item : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getProduct().getPrice());

            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteAll(cartItems);

        return "Order Placed Successfully";
    }
    public List<Order> getOrders(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return orderRepository.findByUser(user);
    }

}