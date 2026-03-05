# ParkingModulator 🚗

ParkingModulator is a **Spring Boot backend application** designed to manage parking operations such as customer registration, vehicle management, parking passes, and pricing rules.

The system simulates a real-world parking management backend where users can register vehicles, purchase parking passes, and manage parking lot pricing and offers.

---

## 🚀 Features

* Customer registration and management
* Vehicle management for customers
* One-time parking pass generation
* Monthly parking pass system
* Parking lot management
* Dynamic pricing and pricing exceptions
* Offer management for parking services
* Payment method handling

---

## 🛠 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA / Hibernate**
* **Maven**
* **REST APIs**
* **H2 / MySQL (Database)**

---

## 📂 Project Structure

```
src/main/java/com/parkingmodulator

├── controller
│   └── Handles REST API requests
│
├── service
│   └── Business logic layer
│
├── repository
│   └── Database interaction using Spring Data JPA
│
├── entity
│   └── JPA entities representing database tables
│
└── ParkingModulatorApplication.java
```

---

## 🗄 Core Entities

The system contains several entities that represent the parking ecosystem:

* **Customer** – Stores customer details
* **Vehicle** – Stores vehicle information linked to customers
* **ParkingLot** – Represents parking locations
* **ParkingOneTimePass** – One-time parking entry pass
* **ParkingMonthlyPass** – Monthly subscription parking pass
* **PaymentMethod** – Payment details used for parking
* **Offers** – Discounts available for parking
* **PricingException** – Special pricing rules

---

## 📡 Example API Endpoints

### Create Customer

```
POST /api/customers
```

### Add Vehicle

```
POST /api/vehicles
```

### Create One-Time Parking Pass

```
POST /api/parking/one-time-pass
```

### Create Monthly Parking Pass

```
POST /api/parking/monthly-pass
```

### Get Parking Lot Details

```
GET /api/parking-lots/{id}
```

---

## ▶️ Running the Project

1. Clone the repository

```
git clone https://github.com/pandeyanik22/ParkingModulator.git
```

2. Navigate to the project directory

```
cd ParkingModulator
```

3. Build the project

```
mvn clean install
```

4. Run the application

```
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 🧪 Future Improvements

* Authentication & Authorization (JWT)
* API documentation using Swagger
* Unit and integration tests
* Docker containerization
* Redis caching
* Parking slot allocation algorithm

---

## 👨‍💻 Author

Developed by **Aniket Pandey**

GitHub:
https://github.com/pandeyanik22

---

## 📄 License

This project is for **learning and demonstration purposes**.
