package com.shopsphere.product;

public abstract class Payment {

    //fields
    protected double amount;

    //constructor
    public Payment(double amount) {
        this.amount = amount;
    }

    //abstract method
    public abstract void processPayment();

    //concrete method
    public void displayAmount() {
        System.out.println("Payment amount: " + amount);
    }
}
