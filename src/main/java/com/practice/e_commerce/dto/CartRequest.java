package com.practice.e_commerce.dto;

public class CartRequest {

    private Integer userId;
    private Integer productId;
    private Integer quantity;

    public CartRequest() {
    }

    public CartRequest(Integer userId, Integer productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}