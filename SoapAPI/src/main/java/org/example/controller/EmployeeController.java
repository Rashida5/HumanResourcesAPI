package org.example.controller;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.servicesImp.EmployeeServiceImpl;

@WebService
public class EmployeeController {
    public EmployeeController(){

    }
  @WebResult(name = "getEmployee")
    public EmployeeGet getEmployee(@WebParam(name="Id") int id){
       EmployeeGet employeeGet= EmployeeServiceImpl.getInstance().getEmployeeById(id);
       return employeeGet;
    }
    @WebResult(name="addEmployee")
    public String addEmployee(EmployeePost employeePost){
     boolean added=EmployeeServiceImpl.getInstance().addEmployee(employeePost);
           if(added){
               return "Added successfully";
           }else{
               return "Failed to added";
           }
    }
   @WebResult(name="updatedEmployee")
    public String updateEmployee(EmployeePost employeePost){
        boolean updated = EmployeeServiceImpl.getInstance().updateEmployee(employeePost);
        if(updated){
            return "Updated Successfully";
        }else{
            return "Failed To Updated";
        }
    }
    @WebResult(name="deleteEmployee")
    public String deleteEmployee(@WebParam(name="Id") int id){
        boolean deleted = EmployeeServiceImpl.getInstance().deleteEmployee(id);
        if(deleted){
            return "Deleted Successfully";
        }else{
            return "Failed To Deleted";
        }
    }

}
