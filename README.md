# MovieFliex API

A REST API developed with the Spring Boot framework to manage a comprehensive catalog of movies, categories, and streaming platforms.

## Features

* **JWT-Based Authentication:** Secure endpoints with a token-based authentication system, including user registration and login.
* **Movie Management (CRUD):** Comprehensive CRUD operations for creating, reading, updating, and deleting movies.
* **Category Management (CRUD):** Full CRUD functionality for movie categories.
* **Streaming Platform Management (CRUD):** Complete CRUD operations for streaming services.
* **Advanced Search:** Filter and search for movies based on their associated category.
* **Interactive API Documentation:** Automatically generated and interactive API documentation powered by SpringDoc OpenAPI (Swagger UI).
* **Database Migrations:** Schema version control and automated migrations managed by Flyway.

## Tech Stack

* **Java 21**
* **Spring Boot 3.3.1**
* **Spring Security:** For handling authentication and authorization.
* **Spring Data JPA:** For data persistence using the Java Persistence API (with Hibernate).
* **Maven:** Build automation and dependency management.
* **MySQL:** Relational database management system.
* **Flyway:** Database migration tool.
* **Lombok:** To reduce boilerplate code.
* **SpringDoc OpenAPI:** For API documentation generation.
* **Dotenv-java:** For managing environment variables.

## Setup and Installation

Follow the steps below to set up and run the project on your local machine.

### Prerequisites

* JDK 21 or higher.
* Apache Maven 3.8 or higher.
* A running instance of a MySQL server.

### Installation Steps

1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-url>
    cd moviefliex
    ```

2.  **Configure Environment Variables:**
    In the project's root directory, create a new file named `.env`. This file is used to store sensitive credentials securely, separate from the source code.

3.  **Populate the `.env` file:**
    Copy the template below into your `.env` file and replace the placeholder values with your local MySQL database credentials.
    ```dotenv
    DATABASE_URL=jdbc:mysql://localhost:3306/moviefliex_db
    DATABASE_USERNAME=your_mysql_user
    DATABASE_PASSWORD=your_mysql_password
    ```
    *Note: Please ensure the `moviefliex_db` database schema exists in your MySQL instance before running the application.*

4.  **Build the Project:**
    Use the Maven Wrapper to compile the project and download all necessary dependencies.
    ```powershell
    # On Windows (PowerShell)
    .\mvnw.cmd clean install
    
    # On Linux/macOS
    ./mvnw clean install
    ```

## Running the Application

Once the project has been successfully built, you can run the application using the following command:
```powershell
# On Windows (PowerShell)
.\mvnw.cmd spring-boot:run

# On Linux/macOS
./mvnw spring-boot:run
