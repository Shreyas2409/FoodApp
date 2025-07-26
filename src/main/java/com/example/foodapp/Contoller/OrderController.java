package com.example.foodapp.Contoller;


import com.example.foodapp.Dto.OrderRequest;
import com.example.foodapp.Model.Order;
import com.example.foodapp.Patterns.Adapter.NutritionProvider;
import com.example.foodapp.Service.OrderFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderFacade orderFacade;
    private final NutritionProvider nutritionProvider;

    public OrderController(OrderFacade orderFacade, NutritionProvider nutritionProvider) {
        this.orderFacade = orderFacade;
        this.nutritionProvider = nutritionProvider;
    }

    @PostMapping("/orders")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest, Principal principal) {
        try {
            Order newOrder = orderFacade.placeOrder(orderRequest, principal.getName());
            return ResponseEntity.ok(newOrder);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/nutrition/{food}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getNutrition(@PathVariable String food) {
        int calories = nutritionProvider.getCalories(food);
        Map<String, Object> response = Map.of(
                "food", food,
                "estimatedCalories", calories
        );
        return ResponseEntity.ok(response);
    }
}
