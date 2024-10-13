# Spring Boot Microservices with Spring Cloud Gateway

## Overview

This project is a set of microservices built using Spring Boot, designed to demonstrate the integration of Spring Cloud Gateway, Spring Security with JWT, and centralized exception handling with AOP (Aspect-Oriented Programming). The architecture is modular, promoting scalability and maintainability.

## Features

- **Microservices Architecture**: Each service is independently deployable and can communicate with each other.
- **Spring Cloud Gateway**: Acts as a gateway for routing requests to microservices, providing a single entry point.
- **Spring Security with JWT**: Implements security using JSON Web Tokens for authentication and authorization.
- **Centralized Exception Handling**: Utilizes AOP to manage exceptions across all microservices consistently.
- **Centralized Logging**: Implements logging using AOP, ensuring that all requests and exceptions are logged in a centralized manner.

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Cloud Gateway
- Spring Security
- JWT (JSON Web Tokens)
- AOP (Aspect-Oriented Programming)
- Maven
- Docker (optional, for containerization)

## Upcoming Features
- add docker file
- spring cache

