package com.practice.e_commerce.repository;

import com.practice.e_commerce.entity.Cart;
import com.practice.e_commerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByUser(User user);

}