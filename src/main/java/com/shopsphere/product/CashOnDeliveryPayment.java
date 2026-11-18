package com.shopsphere.product;

public class CashOnDeliveryPayment extends Payment {

    public CashOnDeliveryPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Cash on delivery selected.");
    }


}
