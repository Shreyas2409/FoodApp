package com.example.foodapp.Patterns.Observer;

import com.example.foodapp.Model.Order;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderSubject {
    private final List<OrderObserver> observers = new ArrayList<>();

    public OrderSubject(List<OrderObserver> observers) {
        this.observers.addAll(observers);
    }

    public void notifyObservers(Order order) {
        observers.forEach(observer -> observer.update(order));
    }
}
