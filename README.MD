# Order Management Api

A comprehensive Order Management System for a restaurant. This application handles the creation, listing, editing, and deletion of orders and their respective items. The system is designed to be modular and efficient, utilizing Spring Boot for the backend API and RabbitMQ for handling real-time order notifications.

## Features

- **CRUD Operations**: Manage products, orders, and items with ease.
- **Real-time Notifications**: Orders are processed with RabbitMQ for seamless notifications.
- **Spring Boot Backend**: A robust and scalable API built with Spring Boot.
- **In-Memory Database**: Leverage H2 for quick testing and prototyping.

## Technologies Used

- **Spring Boot**: For creating a powerful and scalable REST API.
- **RabbitMQ**: To handle and process real-time notifications of orders.
- **H2 Database**: Used for development and testing purposes.
- **Lombok**: For reducing boilerplate code in Java classes.
- **Maven**: For project management and build automation.
- **Docker Compose**: Simplifies the setup and management of the RabbitMQ service via containerization.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.8.1 or higher
- RabbitMQ server installed and running

### Running the Project

1. **Clone the repository**:
   ```bash
   git clone git@github.com:yourusername/order-management-api.git
   cd order-management-api

2. **Start RabbitMQ using Docker Compose**:
   ```bash
   docker-compose up -d

3. **Configure RabbitMQ (Queue, Exchange, Routing Key)**: Access the RabbitMQ management console at http://localhost:15672 (default username/password: guest/guest) and manually create the necessary queue, exchange, and routing key:

- **Queue**: Define the queue that the worker will listen to (order-request-queue).
- **Exchange**: Create an exchange and bind it to the queue (order-request-exchange).
- **Routing Key**: Set up the routing key that directs messages from the exchange to the queue (order-request-rout-key).

4. **Install dependencies**:
   ```bash
   mvn clean install

5. **Run the project**:
   ```bash
   mvn spring-boot:run