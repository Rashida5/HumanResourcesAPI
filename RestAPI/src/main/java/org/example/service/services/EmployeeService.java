package org.example.service.services;

import org.example.service.dto.employee.EmployeePost;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.employee.MonthlyEmployeeTracking;

import java.time.LocalDate;

public interface EmployeeService {

    public boolean addEmployee(EmployeePost employeePost);

    public EmployeeGet getEmployeeById(int id);

    public boolean updateEmployee(EmployeePost employeePost);

    public boolean deleteEmployee(int id);

    public MonthlyEmployeeTracking getMonthlyEmployeeTracking(int id, int month, int year);

}
