
package org.example;

import com.shopsphere.product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        // Store products in ArrayList
        List<Product> products = new ArrayList<>();

        products.add(headphones);
        products.add(keyboard);
        products.add(mouse);
        products.add(monitor);

        // Our first Stream
        products.stream()
                .forEach(product ->
                        System.out.println(product.getName())
                );
        System.out.println("------------------------------------------------");
        //price filtering stream
        products.stream()
                .filter(product -> product.getPrice() >3000)
                .forEach(product -> System.out.println(product.getName()));

        System.out.println("------------------------------------------------");
        // price sorting stream(reversed)
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(product -> System.out.println(product.getName()));
        System.out.println("------------------------------------------------");
        //Name searching stream
        products.stream()
                .filter(product -> product.getName().contains("Gaming"))
                .forEach(product -> System.out.println(product.getName()));
        System.out.println("------------------------------------------------");
        //total inventory stream
      int totalQuantity = products.stream()
                .mapToInt(Product::getQuantity)
                        .sum();
        System.out.println(totalQuantity);

        System.out.println("------------------------------------------------");
        //Most expensive product stream

        Product max = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                        .orElseThrow();
        System.out.println(max.getName());
    }
}
