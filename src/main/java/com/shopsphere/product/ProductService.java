
package com.shopsphere.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ProductService {

    private final Map<Long, Product> productMap = new HashMap<>();

    // Register a product
    public void addProduct(Product product) {
        Objects.requireNonNull(product,"Product cannot be null");
        productMap.put(product.getId(), product);

    }

  /*  // Retrieve product using ID
    public Product getProductById(Long id) {

        Product product = productMap.get(id);

        if (product == null) {

            throw new ProductNotFoundException(
                    "Product not found with ID: " + id
            );

        }

        return product;*/

        public Product getProductById(Long id){
            return Optional.ofNullable(productMap.get(id))
                    .orElseThrow(
                            ()-> new ProductNotFoundException("Product not found with ID:"+id)
                    );
        }

    public Optional<Product> findProductById(Long id) {
            return Optional.ofNullable(productMap.get(id));
    }
    }

