# Shopping App

A simple Spring Boot shopping application that allows users to view products, manage shopping carts, and update product prices.

## Features
- View available products
- Manage customer shopping carts
- Update product prices
- RESTful API endpoints

## Technologies Used
Java 11, Spring Boot, Docker, Maven, JUnit 5, Bootstrap 5

## Getting Started

### Prerequisites
- Java 11+
- Maven
- Docker (optional)

### Installation
```bash
git clone https://github.com/sushmithashenoy/shopping-app.git
cd shopping-app
mvn install


## Running the App

To start the application locally using Maven:

```bash
mvn spring-boot:run
```
Or, to run using Docker:

```bash
docker build -t shopping-app .
docker run -p 8080:8080 shopping-app
```

---

## Testing

To run the test suite and verify the application's functionality:

```bash
mvn test
```

---

## API Endpoints

| Endpoint                            | Description                    |
|--------------------------------------|--------------------------------|
| `/` or `/index`                     | Home page                      |
| `/products`                         | Get a list of all products     |
| `/updateprice`                      | Update product prices          |
| `/customershoppingcart/{custId}`    | Get a specific customer's cart |
| `/getshoppingcarts`                 | Get all shopping carts         |
