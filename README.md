# Itaú Backend Challenge

A RESTful API developed with Java 17 and Spring Boot as a solution for the Itaú Backend Challenge.

The application processes financial transactions entirely in memory and provides real-time statistics based on a configurable time window. The project was designed with a layered architecture, focusing on clean code, maintainability, and separation of responsibilities.

## About

The objective of this challenge is to build a REST API capable of:

* Receiving financial transactions
* Validating business rules
* Storing data exclusively in memory
* Calculating real-time statistics
* Exposing a documented REST API

The implementation fully complies with the challenge requirements by avoiding the use of databases and external caching solutions.

## Features

* RESTful API
* JSON request and response handling
* In-memory transaction storage
* Business rule validation
* Configurable statistics time window
* Real-time statistics calculation
* OpenAPI documentation
* Swagger UI integration
* Structured application logging
* Layered architecture
* Java Streams API
* DoubleSummaryStatistics
* OffsetDateTime support
* Externalized configuration through YAML

## Tech Stack

| Technology              | Purpose                              |
| ----------------------- | ------------------------------------ |
| Java 17                 | Main programming language            |
| Spring Boot             | Application framework                |
| Spring MVC              | REST API development                 |
| Maven                   | Dependency management and build tool |
| Lombok                  | Boilerplate code reduction           |
| Jakarta Validation      | Request validation                   |
| Springdoc OpenAPI       | API documentation                    |
| Swagger UI              | Interactive API documentation        |
| SLF4J                   | Logging facade                       |
| Logback                 | Logging implementation               |
| Java Streams API        | Statistics processing                |
| DoubleSummaryStatistics | Statistical aggregation              |
| OffsetDateTime          | Date and time management             |
| YAML                    | Externalized configuration           |

## Project Structure

```text
src
├── config
├── controller
├── docs
├── model
├── repository
├── service
└── resources
```

### Responsibilities

**Controller**

Handles incoming HTTP requests and delegates operations to the service layer.

**Service**

Contains business rules, validation logic, and statistics calculations.

**Repository**

Stores transactions exclusively in memory according to challenge requirements.

**Model**

Contains request and response objects.

**Config**

Contains application configuration and custom properties.

**Docs**

Contains OpenAPI documentation interfaces to keep controllers focused on business logic.

## Architecture

```text
                 HTTP Request
                      │
                      ▼
              REST Controller
                      │
                      ▼
                  Service Layer
            Business Rules & Validation
                      │
                      ▼
             In-Memory Repository
                      │
                      ▼
              Statistics Calculation
                      │
                      ▼
                HTTP Response
```

## API Endpoints

### POST /transacao

Creates a new transaction.

#### Request

```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

#### Validation Rules

* Value is required
* Date is required
* Value cannot be negative
* Future dates are not allowed

#### Responses

| Status | Description                      |
| ------ | -------------------------------- |
| 201    | Transaction created successfully |
| 400    | Invalid or malformed JSON        |
| 422    | Business rule validation error   |

---

### DELETE /transacao

Deletes all transactions stored in memory.

#### Response

| Status |
| ------ |
| 200 OK |

---

### GET /estatistica

Returns statistics considering only transactions within the configured time window.

#### Response

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.45,
  "min": 10.00,
  "max": 250.50
}
```

If no valid transactions are found, all values are returned as zero.

## Statistics Calculation

Statistics are calculated using Java Streams and DoubleSummaryStatistics.

The API calculates:

* Total number of transactions
* Sum
* Average
* Minimum value
* Maximum value

Only transactions within the configured time window are considered.

## Configuration

The statistics window can be configured through the application properties.

Example:

```yaml
statistics:
  seconds: 60
```

The application validates the configured value to ensure it is greater than zero.

## Logging

Application logs were implemented for important events, including:

* Transaction creation
* Statistics calculation
* Validation failures
* Unexpected errors

This improves observability and simplifies troubleshooting.

## API Documentation

Swagger UI is available after starting the application.

```text
http://localhost:8080/swagger-ui.html
```

## Running the Project

Clone the repository:

```bash
git clone https://github.com/ocainadev/desafio-itau.git
```

Navigate to the project directory:

```bash
cd desafio-itau
```

Run the application:

```bash
./mvnw spring-boot:run
```

## Business Rules Implemented

* Data stored exclusively in memory
* No database usage
* No external cache
* JSON-only communication
* Transaction validation
* Rejection of negative values
* Rejection of future dates
* Configurable statistics time window
* Statistics based on recent transactions
* Automatic calculation of:

  * Count
  * Sum
  * Average
  * Minimum
  * Maximum
* OpenAPI documentation
* Structured logging

## Technical Decisions

This project was designed following software engineering best practices.

Key decisions include:

* Layered architecture (Controller → Service → Repository)
* Separation of OpenAPI documentation from controller implementation
* Externalized configuration through YAML properties
* Centralized business rules in the service layer
* In-memory persistence to comply with challenge requirements
* Use of Java Streams for efficient statistical calculations
* Configurable statistics window instead of hardcoded values
* Structured logging for observability

## Future Improvements

The following enhancements are planned:

* Dockerfile
* Docker Compose
* Unit Tests (JUnit 5)
* Integration Tests
* MockMvc Tests
* Test Coverage Reports
* GitHub Actions CI/CD
* Spring Boot Actuator
* Global Exception Handling using `@ControllerAdvice`
* JaCoCo Coverage Reports

## License

This project was developed for educational purposes as a solution to the Itaú Backend Challenge.

## Author

Cainã Santos

Backend Developer focused on Java and Spring Boot.

GitHub: https://github.com/ocainadev
