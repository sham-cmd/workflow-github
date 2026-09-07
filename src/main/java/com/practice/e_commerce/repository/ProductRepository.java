package com.practice.e_commerce.repository;

import com.practice.e_commerce.entity.Category;
import com.practice.e_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Get Products By Category
    List<Product> findByCategory(Category category);

    // Search Products By Name
    List<Product> findByNameContainingIgnoreCase(String name);



}