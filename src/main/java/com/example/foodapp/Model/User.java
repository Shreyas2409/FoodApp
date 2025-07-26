package com.example.foodapp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles = "ROLE_USER";
}