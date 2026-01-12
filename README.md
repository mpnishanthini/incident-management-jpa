# Incident Management REST API

**Spring Boot | JPA | MySQL**

---

## 📌 Overview

This project is a **Spring Boot RESTful web service** developed as a hands-on **Proof of Concept (POC)** to demonstrate modern Java backend development using:

- Spring Boot
- Spring Data JPA
- MySQL
- Validation
- Exception Handling
- REST APIs

The application manages **Incidents** with full **CRUD operations**, proper **validation**, and **error handling**.

---

## 🛠️ Tech Stack

- Java 17 / 21
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA
- Hibernate
- MySQL 8.x
- HikariCP
- Jakarta Validation
- Maven
- Postman
- Git & GitHub

---

## 📂 Project Structure

```text
src/main/java
 └── com.example.incident_management_jpa
     ├── controller
     │   └── IncidentController.java
     ├── service
     │   └── IncidentService.java
     ├── repository
     │   └── IncidentRepository.java
     ├── entity
     │   └── Incident.java
     ├── exception
     │   ├── GlobalExceptionHandler.java
     │   └── ResourceNotFoundException.java
     └── IncidentManagementJpaApplication.java

---

🗄️ Database Configuration
Database: MySQL
Schema: incident_db
ORM: Hibernate (via Spring Data JPA)

application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/incident_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false



📌 Entity: Incident

Fields with Validation

  * id – Primary Key
  * title – Mandatory
  * description
  * status

@NotBlank(message = "Title is mandatory")
private String title;

🔁 REST API Endpoints
➕ Create Incident
POST /incidents

{
  "title": "Login issue",
  "description": "User unable to login",
  "status": "OPEN"
}

📄 Get All Incidents
GET /incidents

📄 Get Incident by ID
GET /incidents/{id}

✏️ Update Incident
PUT /incidents/{id}

{
  "title": "Login issue updated",
  "description": "Password reset required",
  "status": "IN_PROGRESS"
}

❌ Delete Incident
DELETE /incidents/{id}


⚠️ Validation & Exception Handling

Validation
  - Implemented using Jakarta Validation
  - Mandatory fields return 400 Bad Request
Global Exception Handling
  - Handled using @RestControllerAdvice:
  - MethodArgumentNotValidException
  - ConstraintViolationException
  - ResourceNotFoundException
  - Generic exceptions

Sample Error Response
{
  "title": "Title is mandatory"
}


🧪 Testing
APIs tested using Postman

Validated:

  -Successful CRUD operations
  -Validation errors
  -Not-found scenarios

▶️ How to Run
1️⃣ Clone the Repository
git clone https://github.com/mpnishanthini/incident-management-jpa.git

2️⃣ Create MySQL Database
CREATE DATABASE incident_db;

3️⃣ Update application.properties
4️⃣ Run the Application

mvn spring-boot:run

5️⃣ Access APIs
http://localhost:8082/incidents
