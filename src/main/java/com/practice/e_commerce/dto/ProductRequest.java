package com.practice.e_commerce.dto;

public class ProductRequest {

    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
    private Integer createdBy;
    private Integer categoryId;

    public ProductRequest() {
    }

    public ProductRequest(String name, String description, Double price,
                          Integer stock, String imageUrl,
                          Integer createdBy, Integer categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.createdBy = createdBy;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}