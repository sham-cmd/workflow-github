package com.practice.e_commerce.controller;

import com.practice.e_commerce.entity.Product;
import com.practice.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.practice.e_commerce.dto.ProductRequest;
import com.practice.e_commerce.dto.ProductRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add Product
    @PostMapping
    public Product addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    // Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get Product By Id
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // Update Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @RequestBody Product product) {

        product.setId(id);
        return productService.updateProduct(product);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Integer categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
    // Sort Products
    @GetMapping("/sort")
    public List<Product> sortProducts(@RequestParam String field) {

        return productService.sortProducts(field);

    }
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }


}