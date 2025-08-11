package org.example.productshowcase.service;
import org.example.productshowcase.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class to manage product data.
 * Each product now has a list of image URLs.
 */
@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Populate the list with sample products, including a list of image URLs for each.
        products.add(new Product(
                "RES-001",
                "Handcrafted Wooden Bowl",
                "A beautiful bowl made from locally sourced maple wood. Perfect for salads or as a decorative piece.",
                45.00,
                List.of(
                        "https://placehold.co/600x600/a88b67/FFFFFF?text=Wooden+Bowl",
                        "https://placehold.co/600x600/a88b67/FFFFFF?text=Bowl+Angle+2",
                        "https://placehold.co/600x600/a88b67/FFFFFF?text=Bowl+Angle+3"
                )
        ));
        products.add(new Product(
                "CAN-002",
                "Artisanal Scented Candle",
                "Soy wax candle with a calming lavender and chamomile scent. Burns for over 40 hours.",
                22.50,
                List.of(
                        "https://placehold.co/600x600/c7a8c9/FFFFFF?text=Scented+Candle",
                        "https://placehold.co/600x600/c7a8c9/FFFFFF?text=Candle+Angle+2"
                )
        ));
        products.add(new Product(
                "BAG-003",
                "Organic Cotton Tote Bag",
                "Durable and eco-friendly tote bag with a unique hand-printed design. Great for groceries or daily use.",
                18.00,
                List.of(
                        "https://placehold.co/600x600/e0e0e0/333333?text=Tote+Bag"
                )
        ));
        products.add(new Product(
                "MUG-004",
                "Ceramic Coffee Mug",
                "A sturdy, hand-thrown ceramic mug with a comfortable handle and a speckled glaze finish.",
                28.00,
                List.of(
                        "https://placehold.co/600x600/87a6ba/FFFFFF?text=Ceramic+Mug",
                        "https://placehold.co/600x600/87a6ba/FFFFFF?text=Mug+Angle+2",
                        "https://placehold.co/600x600/87a6ba/FFFFFF?text=Mug+Angle+3",
                        "https://placehold.co/600x600/87a6ba/FFFFFF?text=Mug+Angle+4"
                )
        ));
        products.add(new Product(
                "JRN-005",
                "Leather-bound Journal",
                "A high-quality journal with 200 lined pages and a soft, genuine leather cover.",
                35.00,
                List.of(
                        "https://placehold.co/600x600/6b5b4a/FFFFFF?text=Journal"
                )
        ));
        products.add(new Product(
                "PRN-006",
                "Minimalist Wall Print",
                "A modern, abstract art print on archival paper. Adds a touch of elegance to any room.",
                55.00,
                List.of(
                        "https://placehold.co/600x600/3d4a55/FFFFFF?text=Wall+Print"
                )
        ));
    }

    /**
     * Returns the complete list of products.
     * @return A list of all products.
     */
    public List<Product> findAll() {
        return products;
    }

    /**
     * Searches for products whose name, description, or SKU contains the query string.
     * @param query The search term.
     * @return A list of matching products.
     */
    public List<Product> search(String query) {
        String lowerCaseQuery = query.toLowerCase();
        return products.stream()
                .filter(product ->
                        product.getName().toLowerCase().contains(lowerCaseQuery) ||
                                product.getDescription().toLowerCase().contains(lowerCaseQuery) ||
                                product.getSku().toLowerCase().contains(lowerCaseQuery)) // <-- ADDED THIS LINE
                .collect(Collectors.toList());
    }
}
