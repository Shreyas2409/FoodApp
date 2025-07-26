package com.example.foodapp.Patterns.Decorator;

import org.springframework.stereotype.Component;

@Component
public class BaseFoodItem implements FoodItem {
    private String name;
    private double price;

    public BaseFoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

