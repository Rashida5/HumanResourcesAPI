package org.example.service.mapping.project;

import org.example.persistence.entities.Employee;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.mapping.EntityMapperToModel;

public class EmployeeGetMapper implements EntityMapperToModel<EmployeeGet, Employee> {

    private static EmployeeGetMapper instance ;

    private EmployeeGetMapper(){

    }
    public static EmployeeGetMapper getInstance(){
        if(instance==null)
            instance = new EmployeeGetMapper();
        return instance;
    }

    @Override
    public EmployeeGet convertEntityToModel(Employee e) {
        EmployeeGet employeeProjectGet = new EmployeeGet();
        employeeProjectGet.setEmployeeId(e.getId());
        employeeProjectGet.setFirstName(e.getFirstName());
        employeeProjectGet.setLastName(e.getLastName());
        employeeProjectGet.setPositionName(e.getPosition().getPositionName());
        return employeeProjectGet;
    }
}
