package org.example.service.services;

import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.project.ProjectGet;
import org.example.service.dto.project.ProjectPost;

import java.util.List;

public interface ProjectService {
    boolean addProject(ProjectPost projectPost);

    ProjectGet getProject(int id);
    boolean updateProject(ProjectPost projectPost);
    boolean addEmployeeToProject(int employeeId, int projectId);

    List<EmployeeGet> getEmployeeWorkOnProject(int projectId);
    boolean deleteEmployeeFromProject(int projectId, int employeeID);
}
