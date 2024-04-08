package org.example.service.mapping.employee;


import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;
import org.example.persistence.entities.Position;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.mapping.ModelToEntityMapper;

public class EmployeeUpdateMapper implements ModelToEntityMapper<Employee, EmployeePost> {

    private static EmployeeUpdateMapper instance;
    @Override
    public Employee convertModelToEntity(EmployeePost e) {
        return null;
    }
    public Employee convertModelToEntity(EmployeePost eP, Employee eM){
        if(eP.getFirstName()!=null){
            eM.setFirstName(eP.getFirstName());
        }
        if(eP.getLastName()!=null){
            eM.setLastName(eP.getLastName());
        }
        if(eP.getPositionId()!=0){
            Position position = new Position();
            position.setId(eP.getPositionId());
            eM.setPosition(position);
        }
        if(eP.getDepartmentId()!=0){
            Department department = new Department();
            department.setId(eP.getDepartmentId());
            eM.setDepartment(department);
        }
        return eM;
    }
    private EmployeeUpdateMapper(){

    }
    public static EmployeeUpdateMapper getInstance(){
        if(instance==null){
            instance = new EmployeeUpdateMapper();
        }
        return instance;
    }

}
