package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.servicesImp.EmployeeServiceImpl;

@Path("employees")
public class EmployeeController {
    public EmployeeController(){

    }
    @GET
    @Path("{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeGet getEmployee(@PathParam("Id") int id){
       return EmployeeServiceImpl.getInstance().getEmployeeById(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(EmployeePost employeePost){
     boolean added=EmployeeServiceImpl.getInstance().addEmployee(employeePost);
        System.out.println(added+" "+employeePost);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(EmployeePost employeePost){
        boolean updated = EmployeeServiceImpl.getInstance().updateEmployee(employeePost);
        System.out.println(updated+" "+employeePost);
    }
    @DELETE
    @Path("{Id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("Id") int id){
        boolean deleted = EmployeeServiceImpl.getInstance().deleteEmployee(id);
        System.out.println(deleted);
    }

}
