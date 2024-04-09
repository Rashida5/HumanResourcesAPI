package org.example.service.mapping.employee;

import org.example.persistence.entities.Employee;
import org.example.service.dto.employee.EmployeeGetDetail;
import org.example.service.mapping.EntityMapperToModel;

public class EmployeeDetailGetMapper implements EntityMapperToModel<EmployeeGetDetail, Employee> {

    private static EmployeeDetailGetMapper instance;
    @Override
    public EmployeeGetDetail convertEntityToModel(Employee e) {
        EmployeeGetDetail employeeGet = new EmployeeGetDetail();
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

    private EmployeeDetailGetMapper(){

    }
    public static EmployeeDetailGetMapper getInstance(){
        if(instance==null)
            instance = new EmployeeDetailGetMapper();
        return instance;
    }
}
