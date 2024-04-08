package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.AttendanceDao;
import org.example.persistence.entities.Attendancetrack;

import java.time.LocalDate;
import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {

    private static AttendanceDaoImpl instance;

    public static AttendanceDaoImpl getInstance(){
        if(instance==null)
            instance = new AttendanceDaoImpl();
        return instance;
    }

    private AttendanceDaoImpl(){

    }
    @Override
    public Attendancetrack add(Attendancetrack entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Attendance Added "+ entity.getId());
        return entity;
    }

    @Override
    public Attendancetrack getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(Attendancetrack entity, EntityManager em) {
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
    public Attendancetrack getAttendanceOfSpecificDayForSpecificEmployee(int employeeId, LocalDate date, EntityManager em){
        String jpql = "SELECT e FROM Attendancetrack e WHERE e.employee.id = :Id and e.date = :date";

        TypedQuery<Attendancetrack> query = em.createQuery(jpql, Attendancetrack.class);
        query.setParameter("Id", employeeId);
        query.setParameter("date", date);
        Attendancetrack attendance = null;
        try {
            attendance = query.getSingleResult();
        }catch (Exception e){
            return null;
        }
        return attendance;
    }
    public List<Attendancetrack> getAttendanceOfSpecificDateForSpecificEmployee(int employeeId, int month, int year,EntityManager em){
        String jpql= "SELECT e FROM Attendancetrack e WHERE e.employee.id=:Id and MONTH(e.date) = :month AND YEAR(e.date) = :year";
        TypedQuery<Attendancetrack> query = em.createQuery(jpql, Attendancetrack.class);
        query.setParameter("Id",employeeId);
        query.setParameter("month",month);
        query.setParameter("year",year);

        List<Attendancetrack> list = null;
        try {
            list = query.getResultList();
        }catch (Exception e){
            return null;
        }
        return list;
    }

    @Override
    public boolean delete(Attendancetrack entity, EntityManager em) {
        return false;
    }
}
