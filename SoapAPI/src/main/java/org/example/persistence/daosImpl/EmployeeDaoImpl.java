package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.persistence.daos.EmployeeDao;
import org.example.persistence.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

    private static EmployeeDaoImpl instance;

    @Override
    public Employee add(Employee entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Employee Added "+ entity.getId());
        return entity;
    }

    @Override
    public Employee getById(int id, EntityManager em) {
        Employee employee = em.find(Employee.class, id);

        return employee;
    }

    @Override
    public boolean update(Employee entity, EntityManager em) {
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
    public boolean delete(Employee entity, EntityManager em) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            int updatedRows = em.createQuery(
                            "UPDATE Employee e SET e.isActive = false WHERE e.id = :employeeId")
                    .setParameter("employeeId", entity.getId())
                    .executeUpdate();

            // Commit the transaction
            transaction.commit();
            return updatedRows > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    private EmployeeDaoImpl(){

    }
    public static EmployeeDaoImpl getInstance(){
        if(instance==null)
            instance = new EmployeeDaoImpl();
        return instance;
    }
}
