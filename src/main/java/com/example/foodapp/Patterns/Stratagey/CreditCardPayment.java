package com.example.foodapp.Patterns.Stratagey;


import org.springframework.stereotype.Component;

@Component("creditCard")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        return "SUCCESS";
    }
}
