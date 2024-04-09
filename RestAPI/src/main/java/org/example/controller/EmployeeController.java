package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.dto.employee.EmployeeGetDetail;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.dto.project.ProjectGet;
import org.example.service.servicesImp.EmployeeServiceImpl;

import java.util.List;

@Path("employees")
public class EmployeeController {
    public EmployeeController(){

    }
    @GET
    @Path("{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("Id") int id){
       EmployeeGetDetail employeeGet= EmployeeServiceImpl.getInstance().getEmployeeById(id);
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

    @GET
    @Path("project")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects(@QueryParam("Id") int employeeId){
        List<ProjectGet> projects = EmployeeServiceImpl.getInstance().getProjectEmployeeWorkOn(employeeId);
        if(projects==null)
            return Response.status(404,"Employee not Found").build();
        return Response.ok(projects).build();
    }

}
