package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.ProjectEmployeeDao;
import org.example.persistence.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectEmployeeDaoImpl implements ProjectEmployeeDao {

    private static ProjectEmployeeDaoImpl instance;
    private ProjectEmployeeDaoImpl(){

    }
    public static ProjectEmployeeDaoImpl getInstance(){
        if(instance==null)
            instance = new ProjectEmployeeDaoImpl();
        return instance;
    }

    @Override
    public EmployeeProject add(EmployeeProject entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("EmployeeAddedToProject Added "+ entity.getId());
        return entity;
    }



    @Override
    public EmployeeProject getById(int id, EntityManager em) {
        return null;
    }


    public EmployeeProject getEmployeeProject(int projectID, int employeeID, EntityManager em) {
        String jpql = "SELECT e from EmployeeProject  e WHERE  e.project.id = :projectId and e.employee.id =:employeeId";
        TypedQuery<EmployeeProject> query = em.createQuery(jpql, EmployeeProject.class);
        query.setParameter("projectId",projectID);
        query.setParameter("employeeId",employeeID);
        try {
            EmployeeProject employeeProject = query.getSingleResult();
            return employeeProject;

        }catch (Exception e){

            return null;

        }
    }

    @Override
    public boolean update(EmployeeProject entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(EmployeeProject entity, EntityManager em) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            if (entity != null) {
                em.remove(entity);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    public List<Employee> getEmployeesWorkOnProject(int projectID, EntityManager em){
        String jpql = "SELECT e.employee from EmployeeProject  e WHERE  e.project.id = :id";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("id",projectID);
        try {
            List<Employee> employees = query.getResultList();
            return employees;

        }catch (Exception e){

            return new ArrayList<>();

        }
    }
    public List<Project> getProjectsThatEmployeeWorksOn(int employeeId , EntityManager em){
        String jpql = "SELECT e.project from EmployeeProject  e WHERE  e.employee.id = :id";
        TypedQuery<Project> query = em.createQuery(jpql, Project.class);
        query.setParameter("id",employeeId);
        try {
            List<Project> projects = query.getResultList();
            return projects;

        }catch (Exception e){

            return new ArrayList<>();

        }
    }



}
