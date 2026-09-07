package com.practice.e_commerce.service;

import com.practice.e_commerce.entity.Category;
import com.practice.e_commerce.entity.Product;
import com.practice.e_commerce.repository.CategoryRepository;
import com.practice.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.practice.e_commerce.dto.ProductRequest;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Add Product
    public Product addProduct(ProductRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        product.setCreatedBy(request.getCreatedBy());
        product.setCategory(category);

        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By Id
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Update Product
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete Product
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    // Get Products By Category
    public List<Product> getProductsByCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        return productRepository.findByCategory(category);
    }

    // Search Products
    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public Page<Product> getProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productRepository.findAll(pageable);
    }
    // Sort Products
    public List<Product> sortProducts(String field) {

        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }


}