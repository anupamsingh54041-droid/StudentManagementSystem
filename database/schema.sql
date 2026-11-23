CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roll_no VARCHAR(30) UNIQUE NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(120),
    phone VARCHAR(20),
    course VARCHAR(80) NOT NULL,
    semester INT NOT NULL
);
