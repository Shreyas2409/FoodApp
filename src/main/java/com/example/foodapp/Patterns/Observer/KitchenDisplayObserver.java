package com.example.foodapp.Patterns.Observer;

import com.example.foodapp.Model.Order;
import org.springframework.stereotype.Component;

@Component
public class KitchenDisplayObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("KITCHEN DISPLAY: New order received! #" + order.getId() + " - " + order.getOrderDetails());
    }
}



