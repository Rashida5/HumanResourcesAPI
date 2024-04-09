package org.example.controller;


import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.example.controller.util.DateAndTimeValid;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.project.EmployeeProjectRequest;
import org.example.service.dto.project.ProjectGet;
import org.example.service.dto.project.ProjectPost;
import org.example.service.servicesImp.ProjectServiceImpl;

import java.util.List;

@WebService
public class ProjectController {

    public ProjectController(){

    }
    @WebResult(name = "getProject")
    public ProjectGet getProjectId(@WebParam(name="Id") int Id){
        ProjectGet projectGet = ProjectServiceImpl.getInstance().getProject(Id);
        return projectGet;
    }


    @WebResult(name = "addProject")
    public String addProject(ProjectPost projectPost){
        boolean StartDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getStartDate());
        boolean EndDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getEndDate());
        if(!StartDate||!EndDate){
            return "The Date format entered not allowed";
        }
        boolean added = ProjectServiceImpl.getInstance().addProject(projectPost);
        System.out.println(projectPost+" "+added);
        if(added){
            return "added successfully";
        }else{
            return "Failed To added";
        }

    }
    @WebResult(name = "addEmployee")
    public String addEmployeeToProject(EmployeeProjectRequest data){
        boolean added = ProjectServiceImpl.getInstance().addEmployeeToProject(data.getEmployeeId(), data.getProjectId());
        if(added){
            return "added successfully";
        }
        else{
            return "Failed To added";
        }
    }
   @WebResult(name = "updateProject")
    public String updateProject(ProjectPost projectPost){
        if(projectPost.getStartDate()!=null){
            boolean startDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getStartDate());
            if(!startDate){
                return "The Date format entered not allowed";
            }
        }
        if(projectPost.getEndDate()!=null){
            boolean endDate = DateAndTimeValid.getInstance().checkValidDate(projectPost.getEndDate());
            if(!endDate){
                return "The Date format entered not allowed";
            }
        }
        boolean updated = ProjectServiceImpl.getInstance().updateProject(projectPost);
        if(updated){
            return "updated successfully";
        }
        else{
            return  "Failed To Updated";
        }
    }
   @WebResult(name = "deleteEmployeeFromProject")
    public String deleteEmployeeFromProject(@WebParam(name="employeeId") int employeeId, @WebParam (name = "projectId") int projectId){
        boolean deleted = ProjectServiceImpl.getInstance().deleteEmployeeFromProject(projectId, employeeId);
        if(deleted){
            return  "deleted successfully";
        }else{
            return "Failed To updated";
        }
    }


    @WebResult(name = "GetEmployee")
    public List<EmployeeGet> getEmployeesWorkOnProject(@WebParam(name = "projectId") int projectId){
        List<EmployeeGet> employeeProjectGetList = ProjectServiceImpl.getInstance().getEmployeeWorkOnProject(projectId);
        return employeeProjectGetList;
    }

}
