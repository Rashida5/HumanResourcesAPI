package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.dto.department.DepartmentGet;
import org.example.service.dto.department.DepartmentPost;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.servicesImp.DepartmentServiceImpl;
import org.example.service.servicesImp.EmployeeServiceImpl;

@Path("departments")
public class DepartmentController {

    public DepartmentController(){

    }

    @POST
    @Path("addDepartment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDepartment(DepartmentPost departmentPost){
        boolean added= DepartmentServiceImpl.getInstance().addDepartment(departmentPost);
        return Response.ok(added).build();
    }
    @GET
    @Path("getDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartment(@QueryParam("departmentId") int departmentId){
        DepartmentGet departmentGet = DepartmentServiceImpl.getInstance().getDepartment(departmentId);
        return Response.ok(departmentGet).build();
    }

    @PUT
    @Path("updateDepartment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDepartment(DepartmentPost departmentPost){
        boolean updated = DepartmentServiceImpl.getInstance().updateDepartment(departmentPost);
        return Response.ok(updated).build();
    }



}
