package org.example.controller;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.example.service.dto.department.DepartmentGet;
import org.example.service.dto.department.DepartmentPost;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.servicesImp.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.List;


@WebService
public class DepartmentController {

    public DepartmentController(){

    }

   @WebResult(name="addDepartment")
    public String addDepartment(DepartmentPost departmentPost){
        boolean added= DepartmentServiceImpl.getInstance().addDepartment(departmentPost);
        if(added){
            return "Added Successfully";
        }else{
            return "Failed to Added";
        }
    }
 @WebResult(name="getDepartment")
    public DepartmentGet getDepartment(@WebParam (name="departmentID") int departmentId){
        DepartmentGet departmentGet = DepartmentServiceImpl.getInstance().getDepartment(departmentId);
        return departmentGet;
    }

  @WebResult(name="updateDepartment")
    public String updateDepartment(DepartmentPost departmentPost){
        boolean updated = DepartmentServiceImpl.getInstance().updateDepartment(departmentPost);
      if(updated){
          return "Updated successfully";
      }else{
          return "Failed To updated";
      }
    }
  @WebResult(name="employeesWorkOnDepartment")
    public List<EmployeeGet> getEmployees(@WebParam(name="Id") int deptId){
        List<EmployeeGet> list = DepartmentServiceImpl.getInstance().getEmployeesInDepartment(deptId);
        if(list==null){
            return new ArrayList<>();
        }
        return list;
    }



}
