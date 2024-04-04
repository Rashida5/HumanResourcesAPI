-- Create Positions Table
CREATE TABLE Positions (
                           position_id INT PRIMARY KEY AUTO_INCREMENT,
                           position_name VARCHAR(255),
                           salary DECIMAL(10, 2) -- Salary for each position
);
-- Create Department Table
CREATE TABLE Department (
                            department_id INT PRIMARY KEY AUTO_INCREMENT,
                            department_name VARCHAR(255),
                            manager_id INT
);

-- Create Employee Table
CREATE TABLE Employee (
                          employee_id INT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          department_id INT,
                          position_id INT,
                          salary DECIMAL(10, 2),
                          start_date DATE,
                          end_date DATE,
                          is_active BOOLEAN,
                          FOREIGN KEY (department_id) REFERENCES Department(department_id),
                          FOREIGN KEY (position_id) REFERENCES Positions(position_id)
);

-- Create Address Table
CREATE TABLE Address (
                         address_id INT PRIMARY KEY AUTO_INCREMENT,
                         employee_id INT,
                         city VARCHAR(255),
                         street VARCHAR(255),
                         apartment_number VARCHAR(50),
                         FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- Create Contacts Table
CREATE TABLE Contacts (
                          contact_id INT PRIMARY KEY AUTO_INCREMENT,
                          employee_id INT,
                          mobile_phone VARCHAR(20),
                          email VARCHAR(255),
                          FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- Create Projects Table
CREATE TABLE Projects (
                          project_id INT PRIMARY KEY AUTO_INCREMENT,
                          project_name VARCHAR(255),
                          start_date DATE, -- Start date of the project
                          end_date DATE, -- End date of the project
                          department_id INT,
                          FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

-- Create Attendance Track Table
CREATE TABLE AttendanceTrack (
                                 attendance_id INT PRIMARY KEY AUTO_INCREMENT,
                                 employee_id INT,
                                 date DATE,
                                 arrival_time TIME,
                                 departure_time TIME,
                                 FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- Create Employee_Projects Table for Many-to-Many Relationship between Employee and Projects
CREATE TABLE Employee_Projects (
                                   employee_id INT,
                                   project_id INT,
                                   PRIMARY KEY (employee_id, project_id),
                                   FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
                                   FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);



