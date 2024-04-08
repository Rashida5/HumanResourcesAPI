package org.example.service.services;

import org.example.service.dto.department.DepartmentGet;
import org.example.service.dto.department.DepartmentPost;

public interface DepartmentService {
    public boolean addDepartment(DepartmentPost departmentPost);
    public boolean updateDepartment(DepartmentPost departmentPost);
    public DepartmentGet getDepartment(int id);

   // public boolean deleteDepartmentById(int id);

}
