package com.shopsphere.product;

public class CashOnDeliveryProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Cash on delivery selected.");
        System.out.println("Amount payable: " + amount);
    }


}
