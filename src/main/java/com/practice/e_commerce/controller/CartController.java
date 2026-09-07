package com.practice.e_commerce.controller;

import com.practice.e_commerce.entity.CartItem;
import java.util.List;
import com.practice.e_commerce.dto.CartRequest;
import com.practice.e_commerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartRequest request) {
        return cartService.addToCart(request);
    }
    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Integer userId) {
        return cartService.getCart(userId);
    }
    @PutMapping("/update")
    public String updateCart(@RequestParam Integer cartItemId,
                             @RequestParam Integer quantity) {

        return cartService.updateCart(cartItemId, quantity);
    }
    @DeleteMapping("/remove/{cartItemId}")
    public String removeCartItem(@PathVariable Integer cartItemId) {

        return cartService.removeCartItem(cartItemId);
    }
    @DeleteMapping("/test")
    public String testDelete() {
        return "DELETE Works";
    }

}
