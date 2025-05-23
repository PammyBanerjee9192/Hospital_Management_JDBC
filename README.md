﻿# 🏥Hospital Management System (JDBC)

This is a simple Hospital Management System developed in Java using **JDBC (Java Database Connectivity)** for database operations. It allows for basic CRUD (Create, Read, Update, Delete) operations on entities such as patients, doctors, and appointments.

## 📌 Features

- Add, view, update, and delete patient records
- view doctor records(can be added and updated from admin side only)
- Schedule and manage appointments
- Database connectivity using JDBC
- Console-based user interface

## 🛠️ Technologies Used

- Java (JDK 8 or above)
- JDBC (Java Database Connectivity)
- MySQL (or any relational database)
- IDE (IntelliJ IDEA, Eclipse, etc.)

## 🧾 Database Schema

Here’s a basic structure of the database tables:

### `patients`
| Column Name   | Type         | Description          |
|---------------|--------------|----------------------|
| patient_id    | INT (PK)     | Unique ID            |
| name          | VARCHAR(100) | Patient's name       |
| age           | INT          | Patient's age        |
| gender        | VARCHAR(10)  | Gender               |
| disease       | VARCHAR(255) | Disease/diagnosis    |

### `doctors`
| Column Name   | Type         | Description          |
|---------------|--------------|----------------------|
| doctor_id     | INT (PK)     | Unique ID            |
| name          | VARCHAR(100) | Doctor's name        |
| specialization| VARCHAR(100) | Medical specialty    |

### `appointments`
| Column Name   | Type         | Description          |
|---------------|--------------|----------------------|
| appointment_id| INT (PK)     | Unique ID            |
| patient_id    | INT (FK)     | Linked patient       |
| doctor_id     | INT (FK)     | Linked doctor        |
| appointment_date | DATE      | Date of appointment  |

## 🔌 Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/PammyBanerjee9192/Hospital_Management_JDBC.git
   cd  Hospital_Management_JDBC

