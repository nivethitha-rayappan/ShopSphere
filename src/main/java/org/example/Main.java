
package org.example;

import com.shopsphere.product.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

        //Register or adding products inside the hashMap inside the ProductService class
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


        // Creating object for DigitalProduct class
        DigitalProduct ebook = new DigitalProduct(
                201L,
                "Java Programming E-book",
                499.00,
                100,
                25.5,
                "PDF"
        );

        System.out.println(ebook.getName());
        System.out.println(ebook.getPrice());
        System.out.println(ebook.getDownloadSize());
        System.out.println(ebook.getFileFormat());

        System.out.println(ebook.getProductType());

        // creating an object for physical project
        PhysicalProduct gamingMonitor = new PhysicalProduct(
                301L, "Gaming Monitor", 15999, 8, 5.5, "60 x 40 x 15 cm"
        );
        System.out.println(gamingMonitor.getName());
        System.out.println(gamingMonitor.getWeight());
        System.out.println(gamingMonitor.getProductType());

        //implement runtime polymorphism using a collection.
        List<Product> products = new ArrayList<>();

        products.add(new DigitalProduct(
                201L, "Java E-book", 499.00, 100, 25.5, "PDF"
        ));

        products.add(new PhysicalProduct(
                301L, "Gaming Monitor", 15999.00, 8, 5.5, "60 x 40 x 15 cm"
        ));

        for (Product product : products) {
            System.out.println(product.getName());
            System.out.println(product.getProductType());
        }

        //Abstraction concept
        Payment card = new CardPayment(2500.00);

        card.displayAmount();
        card.processPayment();

        Payment upi = new UPIPayment(1500.00);

        upi.displayAmount();
        upi.processPayment();

        Payment cod = new CashOnDeliveryPayment(1200.00);
        cod.processPayment();
        cod.displayAmount();

        //Interface

        PaymentProcessor cardProcessor = new CardPaymentProcessor();

        cardProcessor.processPayment(2500.00);

        PaymentProcessor upiProcessor = new UPIPaymentProcessor();

        upiProcessor.processPayment(1500.00);

        PaymentProcessor cashOnDeliveryProcessor = new CashOnDeliveryProcessor();
        cashOnDeliveryProcessor.processPayment(1200.00);


        //implement multiple interface
        CardPaymentProcessor cardProcessor1 = new CardPaymentProcessor();

        cardProcessor1.processPayment(2500.00);
        cardProcessor1.refundPayment(500.00);
        cardProcessor1.generateReceipt(2500.00);

        //Default methods

        PaymentProcessor processor = new CardPaymentProcessor();

        processor.displayPaymentMessage();
        processor.processPayment(2500.00);
        PaymentProcessor.showSupportedPaymentInfo();
    }
}
