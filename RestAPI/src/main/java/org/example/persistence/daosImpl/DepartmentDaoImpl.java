package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import org.example.persistence.daos.DepartmentDao;
import org.example.persistence.entities.Department;

public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public Department add(Department entity, EntityManager em) {
        return null;
    }

    @Override
    public Department getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(Department entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(Department entity, EntityManager em) {
        return false;
    }
}
