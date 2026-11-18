
package com.shopsphere.product;


public class CardPayment extends Payment {

    //constructor
    public CardPayment(double amount) {
        super(amount);
    }

    //implementation of parents class abstract method
    @Override
    public void processPayment() {
        System.out.println("Processing card payment: " + amount);
    }
}
