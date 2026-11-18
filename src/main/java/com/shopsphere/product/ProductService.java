
package com.shopsphere.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ProductService {

    private final Map<Long, Product> productMap = new HashMap<>();

    // Register a product
    public void addProduct(Product product) {

        // validates if product is not null
        Objects.requireNonNull(product, "Product cannot be null");

        //validates if id is positive and not null
        if (product.getId() == null || product.getId() < 0) {
            throw new IllegalArgumentException("Product Id must be positive");
        }

        //validates no duplicate IDs or detects duplicate ID's
        if (productMap.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product Id already exists ");
        }
        productMap.put(product.getId(), product);

    }

    //Getting product by id - product type
    public Product getProductById(Long id) {
        return Optional.ofNullable(productMap.get(id))
                .orElseThrow(
                        () -> new ProductNotFoundException("Product not found with ID:" + id)
                );
    }

    //find product by id - optional type
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }
}

