package com.shopsphere.product;

public class CardPaymentProcessor implements PaymentProcessor,Refundable,ReceiptGenerator{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment: " + amount);
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding card payment: " + amount);
    }

    @Override
    public void generateReceipt(double amount) {
        System.out.println("Receipt generated for amount:" + amount);
    }
}
