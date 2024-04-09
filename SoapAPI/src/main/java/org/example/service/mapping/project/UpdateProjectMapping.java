package org.example.service.mapping.project;

import org.example.persistence.entities.Department;
import org.example.persistence.entities.Project;
import org.example.service.dto.project.ProjectPost;

import java.time.LocalDate;

public class UpdateProjectMapping {

    private static UpdateProjectMapping instance;

    public Project convertModelToEntity(Project project, ProjectPost projectPost){
        if(projectPost.getProjectName()!=null){
            project.setProjectName(projectPost.getProjectName());
        }
        if(projectPost.getDepartmentId()!=0){
            Department department = new Department();
            department.setId(projectPost.getDepartmentId());
            project.setDepartment(department);
        }
        if(projectPost.getStartDate()!=null){
            project.setStartDate(LocalDate.parse(projectPost.getStartDate()));
        }
        if(projectPost.getEndDate()!=null){
            project.setEndDate(LocalDate.parse(projectPost.getEndDate()));
        }
        return project;
    }
    private UpdateProjectMapping(){

    }
    public static UpdateProjectMapping getInstance(){
        if(instance==null)
            instance = new UpdateProjectMapping();
        return instance;
    }
}
