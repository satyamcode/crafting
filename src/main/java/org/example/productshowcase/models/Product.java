package org.example.productshowcase.models;

/**
 * Represents a product in our catalog.
 * This is a simple Plain Old Java Object (POJO) to hold product data.
 */

import java.util.List;

/**
 * Represents a product in our catalog.
 * Now supports a list of image URLs for a product gallery.
 */
public class Product {

    private String sku; // Stock Keeping Unit or unique product ID
    private String name;
    private String description;
    private double price;
    private List<String> imageUrls; // A list of URLs for the product images

    // Constructors
    public Product() {
    }

    public Product(String sku, String name, String description, double price, List<String> imageUrls) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrls = imageUrls;
    }

    // Getters and Setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}

