package com.example.foodapp.Patterns.Stratagey;

import org.springframework.stereotype.Component;

@Component("payPal")
public class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        return "SUCCESS";
    }
}