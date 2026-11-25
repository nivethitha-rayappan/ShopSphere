
package com.shopsphere.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    // Test 1: Add product successfully
    @Test
    void shouldAddProductSuccessfully() {

        Product product = new Product(
                101L, "Keyboard", 3499.00, 10
        );

        productService.addProduct(product);

        Product result = productService.getProductById(101L);

        assertNotNull(result);
        assertEquals("Keyboard", result.getName());
    }

    // Test 2: Reject duplicate product ID
    @Test
    void shouldNotAllowDuplicateProductId() {

        Product firstProduct = new Product(
                101L, "Keyboard", 3499.00, 10
        );

        Product secondProduct = new Product(
                101L, "Mouse", 1299.00, 15
        );

        productService.addProduct(firstProduct);

        assertThrows(IllegalArgumentException.class, () -> {
            productService.addProduct(secondProduct);
        });
    }

    // Test 3: Reject null product
    @Test
    void shouldNotAllowNullProduct() {

        assertThrows(NullPointerException.class, () -> {
            productService.addProduct(null);
        });
    }

    // Test 4: Find existing product
    @Test
    void shouldFindExistingProduct() {

        Product product = new Product(
                101L, "Keyboard", 3499.00, 10
        );

        productService.addProduct(product);

        Optional<Product> result =
                productService.findProductById(101L);

        assertTrue(result.isPresent());
        assertEquals("Keyboard", result.get().getName());
    }

    // Test 5: Return empty Optional for missing product
    @Test
    void shouldReturnEmptyWhenProductDoesNotExist() {

        Optional<Product> result =
                productService.findProductById(999L);

        assertTrue(result.isEmpty());
    }
}
