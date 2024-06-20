-- Department Table
INSERT INTO Department (department_id, name, location) VALUES
(101, 'Computer Science', 'Building A'),
(102, 'Electrical Engineering', 'Building B'),
(103, 'Mechanical Engineering', 'Building C');

-- Prof Table
INSERT INTO Prof (prof_id, name, age, department_id) VALUES
(201, 'John Doe', 40, 101),
(202, 'Jane Smith', 35, 102),
(203, 'Michael Johnson', 45, 103);

-- Students Table
INSERT INTO Students (student_id, name, age, department_id) VALUES
(301, 'Alice Brown', 20, 101),
(302, 'Bob Jones', 22, 102),
(303, 'Carol White', 21, 101);

-- Staff Table
INSERT INTO Staff (staff_id, name, experience) VALUES
(401, 'Emily Davis', 5),
(402, 'James Wilson', 10),
(403, 'Olivia Martinez', 8);

-- Administration Table
INSERT INTO Administration (admin_id, position) VALUES
(201, 'Vice Dean'),
(202, 'Treasurer'),
(203, 'Registrar');

