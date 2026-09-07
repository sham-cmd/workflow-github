package com.practice.e_commerce.repository;

import com.practice.e_commerce.entity.Order;
import com.practice.e_commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUser(User user);

}