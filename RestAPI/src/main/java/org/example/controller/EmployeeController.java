package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public Response getEmployee(@PathParam("Id") int id){
       EmployeeGet employeeGet= EmployeeServiceImpl.getInstance().getEmployeeById(id);
       return Response.ok(employeeGet).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(EmployeePost employeePost){
     boolean added=EmployeeServiceImpl.getInstance().addEmployee(employeePost);
            return Response.ok(added).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(EmployeePost employeePost){
        boolean updated = EmployeeServiceImpl.getInstance().updateEmployee(employeePost);
        return Response.ok(updated).build();
    }
    @DELETE
    @Path("{Id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("Id") int id){
        boolean deleted = EmployeeServiceImpl.getInstance().deleteEmployee(id);
        return Response.ok(deleted).build();
    }

}
