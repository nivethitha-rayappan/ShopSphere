package com.shopsphere.product;

public class PhysicalProduct extends Product {

    private double weight;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price, int quantity, double weight, String dimensions) {
        super(id, name, price, quantity);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getProductType() {
        return "Physical Product";
    }
}
