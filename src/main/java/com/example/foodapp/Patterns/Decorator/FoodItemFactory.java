package com.example.foodapp.Patterns.Decorator;

import org.springframework.stereotype.Component;

@Component
public class FoodItemFactory {
    public FoodItem createFoodItem(String type) {
        return switch (type.toLowerCase()) {
            case "pizza" -> new BaseFoodItem("Pizza", 12.99);
            case "burger" -> new BaseFoodItem("Burger", 8.99);
            case "salad" -> new BaseFoodItem("Salad", 6.99);
            default -> throw new IllegalArgumentException("Unknown food type: " + type);
        };
    }
}
