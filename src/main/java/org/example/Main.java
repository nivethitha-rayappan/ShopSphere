
package org.example;

import com.shopsphere.product.Product;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Create product objects
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

        // Create an ArrayList
        List<Product> products = new ArrayList<>();

        // Add products to the list
        products.add(headphones);
        products.add(keyboard);
        products.add(mouse);
        products.add(monitor);
        // Display all products
        for (Product product : products) {

            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());

            System.out.println("-------------------------");
        }

//Hash set implementation
        Set<String> categories = new HashSet<>();
        categories.add("Electronics");
        categories.add("Clothing");
        categories.add("Electronics");
        categories.add("Books");
        categories.add("Clothing");

        System.out.println(categories);
        System.out.println(categories.size());

        //Hashmap implementation
        Map<Long, Product> productMap = new HashMap<>();

        productMap.put(101L, headphones);
        productMap.put(102L, keyboard);
        productMap.put(103L, mouse);
        productMap.put(104L, monitor);

// Retrieve product using ID
        Product product = productMap.get(103L);

        System.out.println(product.getName());


        //Product search process
        Long searchId = 102L;

        Product foundProduct = productMap.get(searchId);

        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct.getName());
        } else {
            System.out.println("Product not found");
        }
    }
}
