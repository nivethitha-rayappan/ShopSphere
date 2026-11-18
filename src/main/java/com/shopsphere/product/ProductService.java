
package com.shopsphere.product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private final Map<Long, Product> productMap = new HashMap<>();

    // Register a product
    public void addProduct(Product product) {

        productMap.put(product.getId(), product);

    }

    // Retrieve product using ID
    public Product getProductById(Long id) {

        Product product = productMap.get(id);

        if (product == null) {

            throw new ProductNotFoundException(
                    "Product not found with ID: " + id
            );

        }

        return product;
    }
}
