package org.example.service.services;

import org.example.service.dto.department.DepartmentGet;
import org.example.service.dto.department.DepartmentPost;
import org.example.service.dto.employee.EmployeeGet;

import java.util.List;

public interface DepartmentService {
    public boolean addDepartment(DepartmentPost departmentPost);
    public boolean updateDepartment(DepartmentPost departmentPost);
    public DepartmentGet getDepartment(int id);

    public List<EmployeeGet> getEmployeesInDepartment(int deptId);

}
