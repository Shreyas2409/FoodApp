package com.example.foodapp.Patterns.Observer;

import com.example.foodapp.Model.Order;
import org.springframework.stereotype.Component;

@Component
public class CustomerNotifierObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("CUSTOMER NOTIFIER: Sending confirmation to " + order.getCustomerName() + " for order #" + order.getId());
    }
}
