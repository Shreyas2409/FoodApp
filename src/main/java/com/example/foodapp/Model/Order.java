package com.example.foodapp.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String orderDetails;
    private double totalAmount;
    private String paymentMethod;
    private String status;
    private LocalDateTime orderTime;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}