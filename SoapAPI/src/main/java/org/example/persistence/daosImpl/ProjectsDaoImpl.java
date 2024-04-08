package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import org.example.persistence.daos.ProjectDao;
import org.example.persistence.entities.Project;

public class ProjectsDaoImpl implements ProjectDao {

    @Override
    public Project add(Project entity, EntityManager em) {
        return null;
    }

    @Override
    public Project getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(Project entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(Project entity, EntityManager em) {
        return false;
    }
}
