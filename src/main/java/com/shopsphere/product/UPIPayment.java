
package com.shopsphere.product;

public class UPIPayment extends Payment {

    //constructor
    public UPIPayment(double amount) {
        super(amount);
    }

    //implementing parent class abstract method
    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment: " + amount);
    }
}
