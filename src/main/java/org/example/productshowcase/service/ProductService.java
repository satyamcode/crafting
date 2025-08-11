package org.example.productshowcase.service;
import org.example.productshowcase.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage product data.
 * In a real application, this would interact with a database.
 * For this example, we're using a hardcoded list of products.
 */
@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Populate the list with some sample products.
        // Replace these with your actual products.
        products.add(new Product(
                "Handcrafted Wooden Bowl",
                "A beautiful bowl made from locally sourced maple wood. Perfect for salads or as a decorative piece.",
                45.00,
                "https://placehold.co/600x400/a88b67/FFFFFF?text=Wooden+Bowl"
        ));
        products.add(new Product(
                "Artisanal Scented Candle",
                "Soy wax candle with a calming lavender and chamomile scent. Burns for over 40 hours.",
                22.50,
                "https://placehold.co/600x400/c7a8c9/FFFFFF?text=Scented+Candle"
        ));
        products.add(new Product(
                "Organic Cotton Tote Bag",
                "Durable and eco-friendly tote bag with a unique hand-printed design. Great for groceries or daily use.",
                18.00,
                "https://placehold.co/600x400/e0e0e0/333333?text=Tote+Bag"
        ));
        products.add(new Product(
                "Ceramic Coffee Mug",
                "A sturdy, hand-thrown ceramic mug with a comfortable handle and a speckled glaze finish.",
                28.00,
                "https://placehold.co/600x400/87a6ba/FFFFFF?text=Ceramic+Mug"
        ));
        products.add(new Product(
                "Leather-bound Journal",
                "A high-quality journal with 200 lined pages and a soft, genuine leather cover.",
                35.00,
                "https://placehold.co/600x400/6b5b4a/FFFFFF?text=Journal"
        ));
        products.add(new Product(
                "Minimalist Wall Print",
                "A modern, abstract art print on archival paper. Adds a touch of elegance to any room.",
                55.00,
                "https://placehold.co/600x400/3d4a55/FFFFFF?text=Wall+Print"
        ));
    }

    /**
     * Returns the complete list of products.
     * @return A list of all products.
     */
    public List<Product> findAll() {
        return products;
    }
}
