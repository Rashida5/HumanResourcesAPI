package org.example.service.mapping.employee;

import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;
import org.example.persistence.entities.Position;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.mapping.ModelToEntityMapper;

public class EmployeePostMapper implements ModelToEntityMapper<Employee, EmployeePost> {

    public static EmployeePostMapper instance;
    @Override
    public Employee convertModelToEntity(EmployeePost e) {
        Employee employee = new Employee();
        employee.setFirstName(e.getFirstName());
        employee.setLastName(e.getLastName());
        Department department = new Department();
        department.setId(e.getDepartmentId());
        employee.setDepartment(department);
        Position position = new Position();
        position.setId(e.getPositionId());
        employee.setPosition(position);

        return employee;
    }
    private EmployeePostMapper(){

    }
    public static EmployeePostMapper getInstance(){
        if(instance==null)
            instance = new EmployeePostMapper();
        return instance;
    }
}
