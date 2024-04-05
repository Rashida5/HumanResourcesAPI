package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import org.example.persistence.daos.AttendanceDao;

public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public AttendanceDao add(AttendanceDao entity, EntityManager em) {
        return null;
    }

    @Override
    public AttendanceDao getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(AttendanceDao entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(AttendanceDao entity, EntityManager em) {
        return false;
    }
}
