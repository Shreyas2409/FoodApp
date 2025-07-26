# Food Ordering Service - Spring Boot & Design Patterns

This project is a complete backend API for a food ordering service, built with Spring Boot. It serves as a practical demonstration of several fundamental Gang of Four (GoF) design patterns in a real-world context. The application is secured using Spring Security and JWT (JSON Web Tokens) and persists data to a PostgreSQL database.

## Features

* **Secure Authentication:** End-to-end user registration and login system using JWT.
* **Role-Based Authorization:** Endpoints are protected using role-based access control (`ROLE_USER`).
* **Order Management:** API endpoints to place and manage food orders.
* **Database Integration:** Uses Spring Data JPA and Hibernate to interact with a PostgreSQL database.
* **Design Pattern Showcase:** Implements six common design patterns to solve specific problems, promoting clean, decoupled, and maintainable code.

---

## Design Patterns Implemented

This project was built to demonstrate how design patterns can be applied to create a robust and scalable application architecture.

### 1. Facade Pattern
* **Purpose:** Provides a simplified, high-level interface to a complex subsystem.
* **Implementation:** The `OrderFacade` class (`com.example.designpatterns.service.OrderFacade`) acts as a single entry point for placing an order. It hides the underlying complexity of creating food items, applying decorators, processing payments, saving the order, and notifying observers. The `OrderController` only needs to interact with this facade, not the individual components.

### 2. Strategy Pattern
* **Purpose:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
* **Implementation:** The `PaymentStrategy` interface (`com.example.designpatterns.patterns.strategy.PaymentStrategy`) defines the contract for a payment method. Concrete implementations like `CreditCardPayment` and `PayPalPayment` provide different ways to pay. The `OrderFacade` selects the appropriate strategy at runtime based on the user's request, without being coupled to the specific payment logic.

### 3. Observer Pattern
* **Purpose:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
* **Implementation:** When a new order is successfully created, the `OrderSubject` notifies all registered `OrderObserver` objects. In this project, `KitchenDisplayObserver` and `CustomerNotifierObserver` are notified to perform their respective actions (e.g., display the order in the kitchen, send a confirmation email to the customer). This decouples the order creation process from the notification logic.

### 4. Factory Pattern
* **Purpose:** Provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.
* **Implementation:** The `FoodItemFactory` (`com.example.designpatterns.patterns.factory.FoodItemFactory`) is responsible for creating different types of `FoodItem` objects (like Pizza, Burger, etc.) based on a string input. This removes the instantiation logic from the client (the `OrderFacade`), making it easy to add new food types without changing the facade's code.

### 5. Decorator Pattern
* **Purpose:** Attaches additional responsibilities to an object dynamically.
* **Implementation:** The `FoodItem` interface is decorated using the `ToppingDecorator`. This allows us to start with a base `FoodItem` (created by the Factory) and dynamically add toppings, each of which adds to the description and price. This provides a flexible alternative to subclassing for extending functionality.

### 6. Adapter Pattern
* **Purpose:** Allows objects with incompatible interfaces to collaborate.
* **Implementation:** The `NutritionServiceAdapter` makes an incompatible `ExternalNutritionApi` (which returns a raw JSON string) compatible with our system's `NutritionProvider` interface (which expects a simple integer for calories). The adapter handles the call to the external service and the transformation of its response.

---

## Tech Stack

* **Framework:** Spring Boot 3.x
* **Language:** Java 17
* **Security:** Spring Security, JSON Web Tokens (JWT)
* **Database:** Spring Data JPA / Hibernate, PostgreSQL
* **Build Tool:** Apache Maven

---

## Prerequisites

Before you begin, ensure you have the following installed:
* JDK 17 or later
* Apache Maven
* PostgreSQL

---

## Setup & Configuration

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Shreyas2409/FoodApp.git](https://github.com/Shreyas2409/FoodApp.git)
    cd FoodApp
    ```

2.  **Create a PostgreSQL Database:**
    * Open `psql` or your favorite database client.
    * Create a new database for the application.
    ```sql
    CREATE DATABASE your_database_name;
    ```

3.  **Configure the Application:**
    * Open the `src/main/resources/application.properties` file.
    * Update the `spring.datasource` properties with your PostgreSQL credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_postgres_user
    spring.datasource.password=your_postgres_password
    ```

---

## Running the Application

You can run the application using the Spring Boot Maven plugin:

```bash
mvn spring-boot:run
