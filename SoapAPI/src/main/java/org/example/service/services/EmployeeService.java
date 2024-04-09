package org.example.service.services;

import org.example.service.dto.employee.EmployeeGetDetail;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.dto.employee.MonthlyEmployeeTracking;
import org.example.service.dto.project.ProjectGet;

import java.util.List;

public interface EmployeeService {

    public boolean addEmployee(EmployeePost employeePost);

    public EmployeeGetDetail getEmployeeById(int id);

    public boolean updateEmployee(EmployeePost employeePost);

    public boolean deleteEmployee(int id);

    public MonthlyEmployeeTracking getMonthlyEmployeeTracking(int id, int month, int year);
    public List<ProjectGet> getProjectEmployeeWorkOn(int id);
}
