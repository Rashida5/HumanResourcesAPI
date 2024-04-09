package org.example.service.mapping.project;

import org.example.persistence.entities.Project;
import org.example.service.dto.project.ProjectGet;
import org.example.service.mapping.EntityMapperToModel;

public class GetProjectMapping implements EntityMapperToModel<ProjectGet, Project> {

    private static GetProjectMapping instance ;

    @Override
    public ProjectGet convertEntityToModel(Project e) {
        ProjectGet projectGet = new ProjectGet();
        projectGet.setProjectId(e.getId());
        projectGet.setProjectName(e.getProjectName());
        projectGet.setStartDate(e.getStartDate().toString());
        projectGet.setEndDate(e.getEndDate().toString());
        projectGet.setDepartmentName(e.getDepartment().getDepartmentName());
        return projectGet;
    }
    private GetProjectMapping(){

    }
    public static GetProjectMapping getInstance(){
        if(instance==null)
            instance = new GetProjectMapping();
        return instance;
    }
}
