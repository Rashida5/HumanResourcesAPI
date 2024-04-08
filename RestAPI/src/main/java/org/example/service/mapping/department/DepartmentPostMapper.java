package org.example.service.mapping.department;

import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;
import org.example.service.dto.department.DepartmentPost;
import org.example.service.mapping.ModelToEntityMapper;

public class DepartmentPostMapper implements ModelToEntityMapper<Department, DepartmentPost> {

    private static DepartmentPostMapper instance;
    @Override
    public Department convertModelToEntity(DepartmentPost e) {
        Department department = new Department();
        department.setDepartmentName(e.getDepartmentName());
        Employee employee = new Employee();
        employee.setId(e.getMangerId());
        department.setManager(employee);
        return department;
    }
    private DepartmentPostMapper(){

    }
    public static DepartmentPostMapper getInstance(){
        if(instance==null)
            instance = new DepartmentPostMapper();
        return instance;
    }
}
