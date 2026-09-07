package com.practice.e_commerce.service;

import com.practice.e_commerce.dto.CartRequest;
import com.practice.e_commerce.entity.Cart;
import com.practice.e_commerce.entity.CartItem;
import com.practice.e_commerce.entity.Product;
import com.practice.e_commerce.entity.User;
import com.practice.e_commerce.repository.CartItemRepository;
import com.practice.e_commerce.repository.CartRepository;
import com.practice.e_commerce.repository.ProductRepository;
import com.practice.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public String addToCart(CartRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        Cart cart = cartRepository.findByUser(user).orElse(null);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart = cartRepository.save(cart);
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(request.getQuantity());

        cartItemRepository.save(cartItem);

        return "Product Added To Cart Successfully";
    }
    public List<CartItem> getCart(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        return cartItemRepository.findByCart(cart);
    }
    public String updateCart(Integer cartItemId, Integer quantity) {

        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart Item Not Found"));

        cartItem.setQuantity(quantity);

        cartItemRepository.save(cartItem);

        return "Cart Updated Successfully";
    }
    public String removeCartItem(Integer cartItemId) {

        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart Item Not Found"));

        cartItemRepository.delete(cartItem);

        return "Item Removed Successfully";
    }

}