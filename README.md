# Registration System with Spring Boot and React

A full-stack user registration system with robust validation, exception handling, and responsive UI.
![Screenshot 2025-04-11 130407](https://github.com/user-attachments/assets/8a6a5130-7cf4-4284-a5e9-f3629a0f242d)
![Screenshot 2025-04-11 130530](https://github.com/user-attachments/assets/4e67eb2a-f275-463b-a6e4-4601987f9cda)




## Features

### Backend (Spring Boot)
- ✅ User registration with email/username validation  
- 🛡️ Custom exception handling with `@ControllerAdvice`  
- 📦 H2 database integration (in-memory or file-based)  
- 🔒 Input validation using Jakarta Bean Validation  
- 📤 Structured JSON responses for success/error cases  

### Frontend (React)
- 📝 Form handling with Formik & Yup validation  
- 🚦 Real-time validation feedback  
- 💅 Custom CSS styling (no Bootstrap)  
- 🚦 Loading states during API calls  
- 🛠️ Error handling with user-friendly messages  

## Tech Stack

### Backend
| Technology | Purpose |
|------------|---------|
| Spring Boot | REST API framework |
| Spring Data JPA | Database operations |
| H2 Database | Embedded database |
| Lombok | Boilerplate reduction |
| Spring Validation | Request validation |

### Frontend
| Technology | Purpose |
|------------|---------|
| React | UI framework |
| Axios | HTTP client |
| Formik | Form state management |
| Yup | Validation schemas |
| CSS3 | Styling |

## Prerequisites

- Java 17+
- Node.js 16+
- Maven 3.8+
- IDE (IntelliJ/VSCode recommended)

## Installation

```bash
1. Clone Repository

git clone https://github.com/yourusername/registration-system.git
cd registration-system

2. Backend Setup

cd backend
mvn clean install

3. Frontend Setup

cd frontend
npm install

Configuration
Backend (application.properties)

# src/main/resources/application.properties
spring.datasource.url=jdbc:h2:file:./data/registrationdb
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

Frontend (src/services/api.js)

const API_URL = 'http://localhost:8080/api/users';


Running the Application
Start Backend

cd backend
mvn spring-boot:run

Start Frontend

cd frontend
npm start


API Endpoints
Method	Endpoint	Description
POST	/api/users/register	Register new user

Sample Request:

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "SecurePass123!"
}

Success Response:

{
  "success": true,
  "message": "User registered successfully"
}


Testing

Postman Collection

   1. Import Postman Collection

   2. Test registration endpoint with valid/invalid data

H2 Database Console

   1. Access http://localhost:8080/h2-console

   2. Use JDBC URL: jdbc:h2:file:./data/registrationdb
