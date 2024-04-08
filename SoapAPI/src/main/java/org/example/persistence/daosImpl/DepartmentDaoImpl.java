package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.DepartmentDao;
import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static DepartmentDaoImpl instance;
    private DepartmentDaoImpl(){

    }
    public static DepartmentDaoImpl getInstance(){
        if(instance==null)
            instance = new DepartmentDaoImpl();
        return instance;
    }

    @Override
    public Department add(Department entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Department Added "+ entity.getId());
        return entity;
    }

    @Override
    public Department getById(int id, EntityManager em) {
        return em.find(Department.class, id);
    }
    public Department getByName(String name, EntityManager em){
        String jpql = "SELECT e FROM Department e WHERE e.departmentName = :name";

        TypedQuery<Department> query = em.createQuery(jpql, Department.class);
        query.setParameter("name", name);
        Department position = null;
        try {
             position = query.getSingleResult();
        }catch (Exception e){
            return null;
        }
        return  position;
    }


    @Override
    public boolean update(Department entity, EntityManager em) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(entity);
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

    @Override
    public boolean delete(Department entity, EntityManager em) {
        EntityTransaction transaction = null;
        try {
           transaction = em.getTransaction();
            transaction.begin();
            Department dept = em.find(Department.class, entity.getId());
            if (dept != null) {
                em.remove(dept);
            }
            transaction.commit();
            return dept != null;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    public List<Employee> getEmployeeOfDepartment(int id, EntityManager em){
        String jpql = "SELECT e from Employee  e WHERE  e.department.id = :id";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("id",id);
        try {
            List<Employee> employees = query.getResultList();
            return employees;
        }catch (Exception e){

            return new ArrayList<>();

        }
    }
}
