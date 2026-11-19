package com.shopsphere.product;

public interface PaymentProcessor {
    void processPayment(double amount);

    //default method
    default void displayPaymentMessage() {
        System.out.println("Payment operation initiated.");
    }

    //static method
    static void showSupportedPaymentInfo() {
        System.out.println("ShopSphere supports multiple payment methods.");
    }
}
