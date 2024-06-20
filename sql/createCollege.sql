create database College;
use College;

CREATE TABLE Staff (
    staff_id INT PRIMARY KEY,
    name VARCHAR(30),
    experience INT
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(30),
    age INT
);

CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    name VARCHAR(50),
    location VARCHAR(100)
);

-- Inserting into Department table
INSERT INTO Department (department_id, name, location) VALUES (1, 'Computer Science', 'Building A');

-- Inserting into Students table
INSERT INTO Students (student_id, name, age) VALUES (1, 'John Doe', 20);

-- Inserting into Staff table
INSERT INTO Staff (staff_id, name, experience) VALUES (1, 'Jane Smith', 5);

CREATE TABLE Prof (
    prof_id INT PRIMARY KEY,
    name VARCHAR(30),
    age INT,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(department_id) ON DELETE CASCADE
);

INSERT INTO Prof (prof_id, name, age, department_id) VALUES (1, 'John Doe', 40, 1);

CREATE TABLE Administration (
    admin_id INT PRIMARY KEY,
    position VARCHAR(30),
    foreign key (admin_id) REFERENCES Prof(prof_id) ON DELETE CASCADE
);

INSERT INTO Administration (admin_id, position) VALUES (1, 'Dean');



