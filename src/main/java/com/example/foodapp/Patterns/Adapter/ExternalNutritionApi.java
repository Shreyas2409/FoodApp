package com.example.foodapp.Patterns.Adapter;

public class ExternalNutritionApi {
    public String getNutritionalDataAsJson(String food) {
        System.out.println("EXTERNAL API: Fetching data for " + food);
        if ("pizza".equalsIgnoreCase(food)) {
            return "{\"calories\": 800, \"fat\": \"30g\"}";
        }
        return "{\"calories\": 550, \"fat\": \"25g\"}";
    }
}