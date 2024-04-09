package org.example.service.servicesImp;

import jakarta.persistence.EntityManager;
import org.example.persistence.daosImpl.DepartmentDaoImpl;
import org.example.persistence.daosImpl.EmployeeDaoImpl;
import org.example.persistence.daosImpl.ProjectEmployeeDaoImpl;
import org.example.persistence.daosImpl.ProjectsDaoImpl;
import org.example.persistence.entities.*;
import org.example.persistence.util.JpaUtil;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.project.ProjectGet;
import org.example.service.dto.project.ProjectPost;
import org.example.service.mapping.project.EmployeeGetMapper;
import org.example.service.mapping.project.GetProjectMapping;
import org.example.service.mapping.project.PostProjectMapping;
import org.example.service.mapping.project.UpdateProjectMapping;
import org.example.service.services.ProjectService;

import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private static ProjectServiceImpl instance;
    private ProjectServiceImpl(){

    }
    public static ProjectServiceImpl getInstance(){
        if(instance==null)
            instance = new ProjectServiceImpl();
        return instance;
    }
    @Override
    public boolean addProject(ProjectPost projectPost) {
        if(projectPost.getDepartmentId()==0)
            return false;
        EntityManager em = JpaUtil.createEntityManager();
        Department department = DepartmentDaoImpl.getInstance().getById(projectPost.getDepartmentId(), em);
        if(department==null){
            em.close();
            return false;
        }
        Project project = PostProjectMapping.getInstance().convertModelToEntity(projectPost);
        project.setDepartment(department);
       Project addedProject= ProjectsDaoImpl.getInstance().add(project, em);
       em.close();
       return addedProject!=null;
    }

    @Override
    public ProjectGet getProject(int id) {
      EntityManager em = JpaUtil.createEntityManager();
      Project project = ProjectsDaoImpl.getInstance().getById(id, em);
      if(project==null){
          em.close();
          return new ProjectGet();
      }
      ProjectGet projectGet = GetProjectMapping.getInstance().convertEntityToModel(project);
        em.close();
      return projectGet;
    }

    @Override
    public boolean updateProject(ProjectPost projectPost) {
        if(projectPost.getProjectID()==0)
            return false;
       EntityManager em = JpaUtil.createEntityManager();
        Project project = ProjectsDaoImpl.getInstance().getById(projectPost.getProjectID(), em);
        if(project==null)
            return false;
        Project updatedProject = UpdateProjectMapping.getInstance().convertModelToEntity(project, projectPost);
        boolean updated = ProjectsDaoImpl.getInstance().update(updatedProject, em);
        return updated;
    }

    @Override
    public boolean addEmployeeToProject(int employeeId, int projectId) {
       if(employeeId==0||projectId==0)
           return false;
       EntityManager em = JpaUtil.createEntityManager();

        EmployeeProject employeeProjectCheck = ProjectEmployeeDaoImpl.getInstance().getEmployeeProject(projectId, employeeId, em);

        if(employeeProjectCheck!=null){
            em.close();
            return false;
        }
       Project project = ProjectsDaoImpl.getInstance().getById(projectId, em);
       Employee employee = EmployeeDaoImpl.getInstance().getById(employeeId, em);

       if(project==null || employee==null)
           return false;

       EmployeeProject employeeProject = new EmployeeProject();


       employeeProject.setEmployee(employee);
       employeeProject.setProject(project);
       EmployeeProjectId employeeProjectId = new EmployeeProjectId();
       employeeProject.setId(employeeProjectId);
       employeeProject.getId().setProjectId(projectId);
       employeeProject.getId().setEmployeeId(employeeId);


       EmployeeProject added = ProjectEmployeeDaoImpl.getInstance().add(employeeProject, em);
       em.close();
       return added!=null;
    }

    @Override
    public List<EmployeeGet> getEmployeeWorkOnProject(int projectId) {
       if(projectId==0){
           return new ArrayList<>();
       }
       EntityManager em = JpaUtil.createEntityManager();
       List<Employee> employees = ProjectEmployeeDaoImpl.getInstance().getEmployeesWorkOnProject(projectId, em);
       if(employees==null)
           return new ArrayList<>();
       List<EmployeeGet> employeeGets = new ArrayList<>();
       for(Employee employee:employees){
//            if(!employee.getIsActive()){
//           continue;
//            }
          EmployeeGet employeeGet = EmployeeGetMapper.getInstance().convertEntityToModel(employee);
           employeeGets.add(employeeGet);
       }
       em.close();
       return employeeGets;
    }

    @Override
    public boolean deleteEmployeeFromProject(int projectId, int employeeID) {
        if(projectId==0||employeeID==0)
            return false;
        EntityManager em = JpaUtil.createEntityManager();
        EmployeeProject employeeProject = ProjectEmployeeDaoImpl.getInstance().getEmployeeProject(projectId, employeeID, em);
       boolean deleted;
        if(employeeProject==null){
            return false;
        }else{
             deleted = ProjectEmployeeDaoImpl.getInstance().delete(employeeProject, em);
        }
        em.close();
        return deleted;
    }

}
