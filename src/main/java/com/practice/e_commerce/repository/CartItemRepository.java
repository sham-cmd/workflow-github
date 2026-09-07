package com.practice.e_commerce.repository;

import com.practice.e_commerce.entity.Cart;
import com.practice.e_commerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByCart(Cart cart);

}