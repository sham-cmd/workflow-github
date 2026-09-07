package com.practice.e_commerce.repository;

import com.practice.e_commerce.entity.Order;
import com.practice.e_commerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findByOrder(Order order);

}