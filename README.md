# Student Management System

**A Java and MySQL Based Desktop Application**

![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![GUI](https://img.shields.io/badge/Interface-Java%20Swing-green)
![Project](https://img.shields.io/badge/Project-BCA%20Academic-purple)

## About the Project

The **Student Management System** is a desktop-based application developed using Java and MySQL. It is designed to simplify the process of managing student records in an organized and efficient manner.

The application provides a graphical user interface through Java Swing and uses JDBC to connect with the MySQL database.

It allows users to add, view, update, delete, and search student information.

## Author Information

| Detail | Information |
|---|---|
| Author | Sakshi Singh |
| Course | Bachelor of Computer Applications (BCA) |
| Semester | 5th Semester |
| College | IITM Janakpuri |
| Project Title | Student Management System |
| Programming Language | Java |
| Database | MySQL |

## GitHub Repository

**Project Repository:**  
https://github.com/anupamsingh54041-droid/StudentManagementSystem

**GitHub Profile:**  
https://github.com/anupamsingh54041-droid

## Technologies Used

- Java 17 – Application development
- Java Swing – Graphical User Interface
- JDBC – Database connectivity
- MySQL – Data storage and management
- Maven – Dependency management
- MySQL Connector/J – Java and MySQL connectivity

## Key Features

1. **Add Student:** Add new student records with personal and academic details.
2. **View Students:** Display student information in a tabular format.
3. **Update Student:** Modify existing student information.
4. **Delete Student:** Remove student records from the database.
5. **Search Student:** Search for student records.
6. **Database Connectivity:** Store and retrieve information using MySQL.

## Project Structure

```text
StudentManagementSystem/
│
├── database/
│   └── schema.sql
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── bca/
│                   └── sms/
│                       ├── Main.java
│                       ├── Student.java
│                       ├── StudentDAO.java
│                       └── DBConnection.java
│
├── pom.xml
└── README.md
```

## Database Details

**Database Name:** `student_management`

**Table Name:** `students`

| Field | Description |
|---|---|
| id | Unique student ID |
| roll_no | Student roll number |
| full_name | Student full name |
| email | Email address |
| phone | Contact number |
| course | Course name |
| semester | Semester number |
| created_at | Record creation date |

The database creation script is available in `database/schema.sql`.

## Installation and Setup

### Requirements

- Java JDK 17 or later
- MySQL Server
- Maven
- IntelliJ IDEA or Eclipse IDE

### Step 1: Clone the Repository

```bash
git clone https://github.com/anupamsingh54041-droid/StudentManagementSystem.git
```

### Step 2: Create the Database

Open MySQL Workbench and execute the SQL commands available in:

```text
database/schema.sql
```

### Step 3: Configure Database Credentials

Set these environment variables with your own MySQL username and password:

```text
SMS_DB_USER=your_mysql_username
SMS_DB_PASSWORD=your_mysql_password
```

Never upload your actual database password to GitHub.

### Step 4: Open the Project

Open the downloaded project in IntelliJ IDEA or Eclipse as a Maven project.

Allow Maven to download the required dependencies.

### Step 5: Run the Application

Open `Main.java` and run the main class after configuring the database connection.

## Working Process

1. The user opens the application.
2. The graphical interface appears.
3. The user enters student details.
4. Java processes the requested operation.
5. JDBC connects to the MySQL database.
6. MySQL stores or retrieves the required information.
7. The application displays the updated records.

## Advantages

- Easy-to-use graphical interface.
- Organized student record management.
- Reduces manual record-keeping.
- Faster searching and updating of records.
- Database-based information storage.
- Demonstrates practical Java and MySQL concepts.

## Future Scope

The application can be enhanced in the future by adding:

- Admin login and authentication.
- Student attendance management.
- Marks and result management.
- PDF report generation.
- Excel export functionality.
- Improved interface and validation.

## Learning Outcomes

This project provides practical understanding of:

- Java programming.
- Object-Oriented Programming.
- Java Swing GUI development.
- JDBC connectivity.
- MySQL database operations.
- CRUD operations.
- Maven project management.
- Exception handling.

## Conclusion

The Student Management System demonstrates how Java and MySQL can be integrated to develop a desktop-based application for managing student records.

The project provides practical experience in Java programming, database connectivity, graphical interface development, and CRUD operations.

---

**Developed by:** Sakshi Singh  
**Course:** BCA – 5th Semester  
**College:** IITM Janakpuri

*This repository contains the project source code. The application should be executed and tested in a desktop Java and MySQL environment before final submission.*
