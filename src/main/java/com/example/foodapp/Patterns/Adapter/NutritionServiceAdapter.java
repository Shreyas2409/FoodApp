package com.example.foodapp.Patterns.Adapter;


import org.springframework.stereotype.Component;

@Component
public class NutritionServiceAdapter implements NutritionProvider {

    private final ExternalNutritionApi externalApi = new ExternalNutritionApi();

    @Override
    public int getCalories(String foodItemName) {
        String jsonData = externalApi.getNutritionalDataAsJson(foodItemName.toLowerCase());
        try {
            return Integer.parseInt(jsonData.split(":")[1].split(",")[0].trim());
        } catch (Exception e) {
            return 0;
        }
    }
}