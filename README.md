# 🩸 Blood Donation Management System

A **full-stack web application** built with **React (frontend)**, **Spring Boot (backend)**, and **MySQL (database)** to manage donors, hospitals, and blood donation requests efficiently.  

---

## 🚀 Features
- User authentication (Login / Sign Up)
- Donor registration & management
- Hospital registration & dashboard
- Create and manage blood donation requests
- View list of available donors
- Search donors by city / blood group
- Update & delete donor records
- Responsive UI with React Router

---

## 🏗️ Tech Stack
**Frontend:**
- React.js  
- Axios (for API calls)  
- React Router  

**Backend:**
- Spring Boot  
- Spring Data JPA (Hibernate + MySQL)  
- REST API  

**Database:**
- MySQL  

---

## ⚙️ Setup Instructions

### 🔹 Backend (Spring Boot)
1. Open the backend project in **IntelliJ / Eclipse / VS Code**.
2. Update database config in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blood_donation_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. Run the Spring Boot app:
   `mvn spring-boot:run`

   or run `BloodDonationSystemBackendApplication.java` directly.

4. The backend will start at:
   `http://localhost:8080`

### 🔹 Frontend (React)
1. Open a new terminal and go to frontend folder:
   `cd frontend`
   
2. Install dependencies:
   `npm install`
   
3. Start React app:
   `npm start`
   
4. The frontend will run at:
   `http://localhost:3000`

### 📌 API Endpoints (Spring Boot)

| Method | Endpoint           | Description          |
| ------ | ------------------ | -------------------- |
| GET    | `/api/donors`      | Get all donors       |
| GET    | `/api/donors/{id}` | Get donor by ID      |
| POST   | `/api/donors`      | Add new donor        |
| PUT    | `/api/donors/{id}` | Update donor details |
| DELETE | `/api/donors/{id}` | Delete donor         |



---

### 📜 License

This project is licensed under the MIT License – you’re free to use and modify it.
