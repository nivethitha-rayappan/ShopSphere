package com.shopsphere.product;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class ProductTest {

    Product product;
    @BeforeAll
    static void startTests(){
        System.out.println("Starting ShopSphere Product Tests");
    }
    @BeforeEach
    void setUp(){
        product = new Product(
                101L,
                "Wireless Headphones",
                2499.00,
                10
        );
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Test execution completed!");
    }

    @Test
    void shouldCreateProductSuccessfully() {
        assertEquals(101L, product.getId());
        assertEquals("Wireless Headphones", product.getName());
        assertEquals(2499.00, product.getPrice());
        assertEquals(10, product.getQuantity());
    }

    @Test
    void shouldNotAllowNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            product.setPrice(-500.00);
        });
    }

    @Test
    void shouldNotAllowNullProductName() {
        assertThrows(IllegalArgumentException.class, () -> {
            product.setName(null);
        });
    }

    @Test
    void shouldNotAllowNegativeQuantity(){
        assertThrows(IllegalArgumentException.class,()->{
            product.setQuantity(-5);
        });
    }

    @Test
    void shouldNotAllowBlankName(){
        assertThrows(IllegalArgumentException.class,()->{
            product.setName(" ");
        });
    }

    @AfterAll
    static void finishTests() {
        System.out.println("ShopSphere Product Tests Completed");
    }
}
