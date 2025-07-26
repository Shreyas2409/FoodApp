package com.example.foodapp.Patterns.Observer;

import com.example.foodapp.Model.Order;

public interface OrderObserver {
    void update(Order order);
}

