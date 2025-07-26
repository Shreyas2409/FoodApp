package com.example.foodapp.Dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {
    private String customerName;
    private String foodType;
    private List<Map<String, Object>> toppings;
    private String paymentMethod;
}
