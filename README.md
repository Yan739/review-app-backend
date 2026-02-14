# Review App Backend

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-green?logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-red?logo=apachemaven&logoColor=white)

</div>

---

## Description

A complete customer review retrieval system developed with **Spring Boot 4.0.1**. It allows managing clients and their sentiments (reviews), supporting positive and negative feedback classification. Demonstrates clean layered architecture (**Controller** → **Service** → **Repository** → **Entity**), error handling, and REST best practices.

---

## Features

-   **Client Management**
    -   Create, Read, Update, Delete clients
    -   Email validation and uniqueness checks

-   **Sentiment Analysis**
    -   Create, Read, Update, Delete sentiments (reviews)
    -   Categorization into POSITIF or NEGATIF
    -   Association with specific clients

-   **Architecture & Quality**
    -   Clean layered architecture
    -   Centralized error handling
    -   Data validation (Jakarta Validation)
    -   CORS enabled for frontend integration

---

## Technologies

| Technology | Version |
|---|---|
| Java | 17+ |
| Spring Boot | 4.0.1 |
| Spring Data JPA | - |
| MySQL | - |
| Maven | - |

---

## Project Structure
```
com.yann.review_app_backend
│
├── controller/       → REST endpoints (ClientController, SentimentController)
├── service/          → Business logic (ClientService, SentimentService)
├── repository/       → JPA interfaces for persistence
├── entity/           → JPA entities (Client, Sentiment, TypeSentiment)
└── exception/        → Custom exceptions (ClientNotFoundException, etc.)
```

---

## Endpoints

### Clients

| Method | Endpoint | Description | Body Required |
|---|---|---|---|
| POST | `/client` | Create new client | Yes |
| GET | `/client` | List all clients | No |
| GET | `/client/{id}` | Get client by ID | No |
| PUT | `/client/{id}` | Update client | Yes |
| DELETE | `/client/{id}` | Delete client | No |

### Sentiments

| Method | Endpoint | Description | Body Required |
|---|---|---|---|
| POST | `/sentiment` | Create new sentiment | Yes |
| GET | `/sentiment` | List all sentiments | No |
| GET | `/sentiment/{id}` | Get sentiment by ID | No |
| PUT | `/sentiment/{id}` | Update sentiment | Yes |
| DELETE | `/sentiment/{id}` | Delete sentiment | No |

---

## Examples

### Create Client
```http
POST /client
Content-Type: application/json

{
  "email": "user@example.com"
}
```

### Create Sentiment
```http
POST /sentiment
Content-Type: application/json

{
  "text": "Great service, very satisfied!",
  "type": "POSITIF",
  "client": {
    "id": 1
  }
}
```

---

## Installation

### Prerequisites
```bash
# Java 17+
java -version

# Maven
mvn -version

# MySQL Server running
```

### Setup
```bash
# Clone the project
git clone <repository-url>
cd review-app-backend

# Configure database
# Edit src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# Build
./mvnw clean package

# Run the project
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

---

Personal project — public — no restrictive license.

