package com.example.foodapp.Patterns.Decorator;


import org.springframework.stereotype.Component;

@Component
public class ToppingDecorator extends FoodItemDecorator {
    private String toppingName;
    private double toppingPrice;

    public ToppingDecorator(FoodItem decoratedFoodItem, String toppingName, double toppingPrice) {
        super(decoratedFoodItem);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with " + toppingName;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + toppingPrice;
    }
}

