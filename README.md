🚗 ParkingModulator

A backend system for managing a real-world parking ecosystem — built using Java, Spring Boot, and MySQL.
This project simulates how modern parking platforms handle users, vehicles, passes, pricing, and transactions at scale.

📌 About the Project

ParkingModulator is designed to model a complete parking management system from scratch.
The idea was to go beyond simple CRUD APIs and build something closer to how actual parking platforms work in production.

It supports:

Customer and vehicle management

One-time and monthly parking passes

Dynamic pricing and offers

Clean API structure following REST principles

The project focuses on clean architecture, scalability, and real-world backend design.

⚙️ Tech Stack

Language: Java 17

Framework: Spring Boot

ORM: Hibernate / Spring Data JPA

Database: MySQL

Build Tool: Maven

API Style: REST

🧩 System Design

The application follows a layered architecture:

Controller → Service → Repository → Database

This separation makes the system:

Easy to maintain

Testable

Scalable for future features

🏗️ Core Features
👤 Customer & Vehicle Management

Register customers

Add and manage multiple vehicles per user

🅿️ Parking Operations

Issue one-time parking passes

Manage monthly subscriptions

Track parking lot availability

💰 Pricing & Offers

Dynamic pricing rules

Special offers and exceptions

📊 Data Modeling

Designed 8+ entities including:

Customer

Vehicle

ParkingLot

Passes

Offers

Fully normalized relational schema

🔗 Sample APIs
POST /api/customers
POST /api/parking/one-time-pass
GET  /api/parking-lots/{id}

All endpoints follow REST conventions and proper request/response structuring.

🚀 Key Highlights

Built with real-world system design thinking

Clean separation of concerns using layered architecture

Handles multi-entity relationships efficiently

Designed keeping scalability and extensibility in mind

Follows industry practices used in backend systems

📦 How to Run

Clone the repository

git clone https://github.com/pandeyanik22/ParkingModulator.git

Navigate to project folder

cd ParkingModulator

Configure MySQL in application.properties

Run the application

mvn spring-boot:run
📈 Future Improvements

Add authentication & authorization (JWT)

Introduce caching (Redis)

Dockerize for easier deployment

Add API rate limiting

Implement real-time slot tracking

🤝 Contributing

This is a personal learning project, but suggestions and improvements are always welcome.

👨‍💻 Author

Aniket Deo Pandey
Backend Java Developer
