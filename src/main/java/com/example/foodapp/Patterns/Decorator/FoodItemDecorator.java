package com.example.foodapp.Patterns.Decorator;

public abstract class FoodItemDecorator implements FoodItem {
    protected FoodItem decoratedFoodItem;

    public FoodItemDecorator(FoodItem decoratedFoodItem) {
        this.decoratedFoodItem = decoratedFoodItem;
    }

    public String getDescription() {
        return decoratedFoodItem.getDescription();
    }

    public double getPrice() {
        return decoratedFoodItem.getPrice();
    }
}