package org.example.service.mapping.employee;

import org.example.persistence.entities.Employee;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.mapping.EntityMapperToModel;

public class EmployeeGetMapper implements EntityMapperToModel<EmployeeGet, Employee> {

    private static EmployeeGetMapper instance;
    @Override
    public EmployeeGet convertEntityToModel(Employee e) {
        EmployeeGet employeeGet = new EmployeeGet();
        employeeGet.setEmployeeId(e.getId());
        employeeGet.setFirstName(e.getFirstName());
        employeeGet.setLastName(e.getLastName());
        employeeGet.setHire_date(e.getStartDate().toString());
        if(e.getEndDate().equals(e.getStartDate())){
            employeeGet.setEnd_date("still work");
        }else{
            employeeGet.setEnd_date(e.getEndDate().toString());
        }
        employeeGet.setNetSalary(e.getPosition().getSalary());
        employeeGet.setPositionName(e.getPosition().getPositionName());
        return employeeGet;
    }

    private EmployeeGetMapper(){

    }
    public static EmployeeGetMapper getInstance(){
        if(instance==null)
            instance = new EmployeeGetMapper();
        return instance;
    }
}
