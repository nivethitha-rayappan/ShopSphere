
package com.shopsphere.product;

public class Product {

    private Long id;
    private String name;
    private double price;
    private int quantity;

    // No-argument constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(Long id, String name, double price, int quantity) {

        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters with validation

    public void setId(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be positive"
            );
        }

        this.id = id;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty"
            );
        }

        this.name = name;
    }

    public void setPrice(double price) {

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Product price cannot be negative"
            );
        }

        this.price = price;
    }

    public void setQuantity(int quantity) {

        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Product quantity cannot be negative"
            );
        }

        this.quantity = quantity;
    }
}
