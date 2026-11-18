
package org.example;

import com.shopsphere.product.Product;
import com.shopsphere.product.ProductNotFoundException;
import com.shopsphere.product.ProductService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Create products
        Product headphones = new Product(
                101L, "Wireless Headphones", 2499.00, 10
        );

        Product keyboard = new Product(
                102L, "Mechanical Keyboard", 3499.00, 15
        );

        Product mouse = new Product(
                103L, "Gaming Mouse", 1299.00, 20
        );

        Product monitor = new Product(
                104L, "Gaming Monitor", 15999.00, 8
        );

        //Creating object for ProductService
        ProductService productService = new ProductService();

        //Registe or adding products inside the hashMap inside the ProductService class
        productService.addProduct(headphones);
        productService.addProduct(keyboard);
        productService.addProduct(mouse);
        productService.addProduct(monitor);

        //Searching for existing product by product id and catching error if not

        try {
            Product productFound = productService.getProductById(102L);
            System.out.println("Product Found: " + productFound.getName());
        } catch (ProductNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        //Searching for missing product by product id and catching error if not

        try {
            Product productFound = productService.getProductById(999L);
            System.out.println("Product Found: " + productFound.getName());
        } catch (ProductNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        // optional method calling in service
        Optional<Product> result = productService.findProductById(102L);

        result.ifPresent(product ->
                System.out.println("Found: " + product.getName())
        );

        Optional<Product> missing = productService.findProductById(999L);

        System.out.println("Is missing product empty? " + missing.isEmpty());

        String productName = productService.findProductById(103L)
                .map(Product::getName)
                .orElse("Product not available");

        System.out.println(productName);

        //inserting new product
        Product newProduct = new Product(
                105L, "USB-C Hub", 1999.00, 12
        );

        // Test 1: Valid product
        try {
            productService.addProduct(newProduct);
            System.out.println("Valid product added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test 2: Duplicate ID
        try {
            Product duplicate = new Product(
                    105L, "Wireless Mouse", 999.00, 5
            );
            productService.addProduct(duplicate);
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate test: " + e.getMessage());
        }

        // Test 3: Product with null ID
        try {
            Product invalidProduct = new Product();
            productService.addProduct(invalidProduct);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ID test: " + e.getMessage());
        }

        // Test 4: Null product object
        try {
            productService.addProduct(null);
        } catch (NullPointerException e) {
            System.out.println("Null product test: " + e.getMessage());
        }

    }
}
