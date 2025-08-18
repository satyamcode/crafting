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
                "RPF-001",
                "Large Customised Resin Photo Frame",
                "Resin Photo Frame for Home Decor Personalized Gift Customized with Your Photos &Template 8, 10 ,12 inch sizes, price will change according to size",
                799.00,
                List.of(
                        "/images/large_photo_frame_zig_zag.png",
                        "/images/large_photo_frame_zig_zag_4.png",
                        "/images/large_photo_frame_zig_zag_2.png",
                        "/images/large_photo_frame_zig_zag_3.png"
                )
        ));
        products.add(new Product(
                "RPF-002",
                "Mini Customised Resin Frame",
                "This Customised Resin Frame is 4 inches. This is the best resin birthday gift ideas for your " +
                        "best friend or photo frame gift for your loved ones.",
                299.00,
                List.of(
                        "images/mini_4_inch_frame_1.png",
                        "images/mini_4_inch_frame_2.jpg"
                )
        ));
        products.add(new Product(
                "RPF-003",
                "Resin Mini Picture Cutout frame stand",
                "This Customised Resin Frame is 1.5 inches. photo frame gift for your loved ones.",
                149.00,
                List.of(
                        "/images/mini_photo_frame_3.png",
                        "/images/min_photo_frame_1.jpeg",
                        "/images/mini_photo_frame_2.jpeg"
                )
        ));
        products.add(new Product(
                "MUG-004",
                "Alphabet Resin Keychain with different Flakes – Personalized Initial Keychain",
                "Elegant handmade resin keychain with real rose flakes, personalized with your chosen initial. " +
                        "A stylish and thoughtful gift for everyday use or special occasions.",
                89.00,
                List.of(
                        "/images/alphabet_keychain_1.png",
                        "/images/alphabet_keychain_2.png",
                        "/images/alphabet_keychain_3.png"
                )
        ));
        products.add(new Product(
                "JRN-005",
                "PersonalizeMe Resin Name Keychain",
                "Custom resin keychain designed with your name for a unique, stylish touch and shape. " +
                        "A perfect accessory or personalized gift for everyday use.",
                99.00,
                List.of(
                        "/images/name_keyChain.png"
                )
        ));
        products.add(new Product(
                "PRN-006",
                "Resin Art Round Keychain with Photo",
                "Beautifully handcrafted resin round keychain customized with your photo. A perfect keepsake to carry memories with you everywhere.",
                99.00,
                List.of(
                        "/images/photo_key_chain.png",
                        "/images/photo_keychain.png"
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
