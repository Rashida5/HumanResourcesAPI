package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.persistence.daos.ProjectDao;
import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;
import org.example.persistence.entities.Project;

public class ProjectsDaoImpl implements ProjectDao {

    private static ProjectsDaoImpl instance;

    private ProjectsDaoImpl(){

    }
    public static ProjectsDaoImpl getInstance(){
        if(instance==null)
            instance = new ProjectsDaoImpl();
        return instance;
    }

    @Override
    public Project add(Project entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);

        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Project Added "+ entity.getId());
        return entity;
    }

    @Override
    public Project getById(int id, EntityManager em) {
        return em.find(Project.class, id);
    }

    @Override
    public boolean update(Project entity, EntityManager em) {
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
    public boolean delete(Project entity, EntityManager em) {
        return false;
    }
}
