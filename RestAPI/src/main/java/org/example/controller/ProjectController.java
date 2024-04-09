package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.controller.util.DateAndTimeValid;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.project.EmployeeProjectRequest;
import org.example.service.dto.project.ProjectGet;
import org.example.service.dto.project.ProjectPost;
import org.example.service.servicesImp.ProjectServiceImpl;

import java.util.List;

@Path("projects")
public class ProjectController {

    public ProjectController(){

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectId(@QueryParam("Id") int Id){
        ProjectGet projectGet = ProjectServiceImpl.getInstance().getProject(Id);
        return Response.ok(projectGet).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProject(ProjectPost projectPost){
        boolean StartDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getStartDate());
        boolean EndDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getEndDate());
        if(!StartDate||!EndDate){
            return Response.status(400,"The Date format entered not allowed").build();
        }
        boolean added = ProjectServiceImpl.getInstance().addProject(projectPost);
        System.out.println(projectPost+" "+added);
        if(added){
            return Response.status(201,"added successfully").build();
        }else{
            return Response.status(200,"Failed To added").build();
        }

    }
    @POST
    @Path("employee")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployeeToProject(EmployeeProjectRequest data){
        boolean added = ProjectServiceImpl.getInstance().addEmployeeToProject(data.getEmployeeId(), data.getProjectId());
        if(added){
            return Response.status(201,"added successfully").build();
        }
        else{
            return Response.status(200,"Failed To added").build();
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProject(ProjectPost projectPost){
        if(projectPost.getStartDate()!=null){
            boolean startDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getStartDate());
            if(!startDate){
                return Response.status(400,"The Date format entered not allowed").build();
            }
        }
        if(projectPost.getEndDate()!=null){
            boolean endDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getEndDate());
            if(!endDate){
                return Response.status(400,"The Date format entered not allowed").build();
            }
        }
        boolean updated = ProjectServiceImpl.getInstance().updateProject(projectPost);
        if(updated){
            return Response.status(200,"updated successfully").build();
        }
        else{
            return Response.status(200, "Failed To Updated").build();
        }
    }
    @DELETE
    @Path("employee")
    public Response deleteEmployeeFromProject(@QueryParam("employeeId") int employeeId, @QueryParam("projectId") int projectId){
        boolean deleted = ProjectServiceImpl.getInstance().deleteEmployeeFromProject(projectId, employeeId);
        if(deleted){
            return Response.status(200, "deleted successfully").build();
        }else{
            return Response.status(200, "Failed To updated").build();
        }
    }

    @GET
    @Path("employee")
    public Response getEmployeesWorkOnProject(@QueryParam("projectId") int projectId){
        List<EmployeeGet> employeeProjectGetList = ProjectServiceImpl.getInstance().getEmployeeWorkOnProject(projectId);
        return Response.ok(employeeProjectGetList).build();
    }

}
