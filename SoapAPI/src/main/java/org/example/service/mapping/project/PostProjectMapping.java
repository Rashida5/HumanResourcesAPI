package org.example.service.mapping.project;

import org.example.persistence.entities.Department;
import org.example.persistence.entities.Project;
import org.example.service.dto.project.ProjectPost;
import org.example.service.mapping.ModelToEntityMapper;

import java.time.LocalDate;

public class PostProjectMapping implements ModelToEntityMapper<Project, ProjectPost> {

    private static PostProjectMapping instance;
    @Override
    public Project convertModelToEntity(ProjectPost e) {
        Project project = new Project();
        project.setProjectName(e.getProjectName());
        Department department = new Department();
        department.setId(e.getDepartmentId());
        project.setDepartment(department);
        project.setStartDate(LocalDate.parse(e.getStartDate()));
        project.setEndDate(LocalDate.parse(e.getEndDate()));

        return project;
    }
    private PostProjectMapping(){

    }
    public static PostProjectMapping getInstance(){
        if(instance==null)
            instance = new PostProjectMapping();
        return instance;
    }
}
