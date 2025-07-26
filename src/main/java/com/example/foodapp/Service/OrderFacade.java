package com.example.foodapp.Service;
import com.example.foodapp.Dto.OrderRequest;
import com.example.foodapp.Model.Order;
import com.example.foodapp.Model.User;
import com.example.foodapp.Patterns.Decorator.FoodItem;
import com.example.foodapp.Patterns.Decorator.ToppingDecorator;
import com.example.foodapp.Patterns.Factory.FoodItemFactory;
import com.example.foodapp.Patterns.Observer.OrderSubject;
import com.example.foodapp.Patterns.Stratagey.PaymentStrategy;
import com.example.foodapp.Repository.OrderRepository;
import com.example.foodapp.Repository.UserRepository;


import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class OrderFacade {

    private final FoodItemFactory foodItemFactory;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ApplicationContext applicationContext;
    private final OrderSubject orderSubject;

    public OrderFacade(FoodItemFactory foodItemFactory, OrderRepository orderRepository, UserRepository userRepository, ApplicationContext applicationContext, OrderSubject orderSubject) {
        this.foodItemFactory = foodItemFactory;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.applicationContext = applicationContext;
        this.orderSubject = orderSubject;
    }

    public Order placeOrder(OrderRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        FoodItem foodItem = foodItemFactory.createFoodItem(request.getFoodType());

        if (request.getToppings() != null) {
            for (var topping : request.getToppings()) {
                String name = (String) topping.get("name");
                double price = ((Number) topping.get("price")).doubleValue();
                foodItem = new ToppingDecorator(foodItem, name, price);
            }
        }

        PaymentStrategy paymentStrategy = applicationContext.getBean(request.getPaymentMethod(), PaymentStrategy.class);
        String paymentStatus = paymentStrategy.pay(foodItem.getPrice());

        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setOrderDetails(foodItem.getDescription());
        order.setTotalAmount(foodItem.getPrice());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setStatus(paymentStatus);
        order.setOrderTime(LocalDateTime.now());
        order.setUser(user);

        Order savedOrder = orderRepository.save(order);

        orderSubject.notifyObservers(savedOrder);

        return savedOrder;
    }
}