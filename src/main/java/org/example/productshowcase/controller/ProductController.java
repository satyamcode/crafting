package org.example.productshowcase.controller;

import org.example.productshowcase.models.Product;
import org.example.productshowcase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Controller to handle requests for the product page.
 */
@Controller
public class ProductController {

    private final ProductService productService;

    // Inject the WhatsApp number from application.properties
    @Value("${whatsapp.number}")
    private String whatsappNumber;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Handles the root URL ("/") and displays the list of products.
     * It now accepts an optional 'search' parameter to filter products.
     * @param model The Spring UI Model to pass data to the view.
     * @param search The search query from the user.
     * @return The name of the Thymeleaf template to render.
     */
    @GetMapping("/")
    public String showProducts(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Product> products;
        if (search != null && !search.trim().isEmpty()) {
            products = productService.search(search);
        } else {
            products = productService.findAll();
        }

        model.addAttribute("products", products);
        model.addAttribute("whatsappNumber", whatsappNumber);
        model.addAttribute("controller", this); // Pass the controller instance
        model.addAttribute("searchQuery", search); // Pass search query back to the view
        return "products";
    }

    /**
     * Utility method to URL-encode text for the WhatsApp message.
     * This method is called directly from the Thymeleaf template.
     * @param value The text to encode.
     * @return The URL-encoded string.
     */
    public String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // This should not happen with UTF-8
            return "";
        }
    }
}
