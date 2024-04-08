package org.example.service.servicesImp;

import jakarta.persistence.EntityManager;
import org.example.persistence.daosImpl.AttendanceDaoImpl;
import org.example.persistence.entities.Attendancetrack;
import org.example.persistence.entities.Employee;
import org.example.persistence.util.JpaUtil;
import org.example.service.dto.attendance.AttendanceGet;
import org.example.service.mapping.attendance.AttendanceGetMapper;
import org.example.service.services.AttendanceService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private static AttendanceServiceImpl instance;
    private AttendanceServiceImpl(){

    }
    public static AttendanceServiceImpl getInstance(){
        if(instance==null)
            instance = new AttendanceServiceImpl();
        return instance;
    }
    @Override
    public boolean markArrive(int id, LocalTime time, LocalDate date) {
        EntityManager em = JpaUtil.createEntityManager();
        Attendancetrack attendancetrack = AttendanceDaoImpl.getInstance().getAttendanceOfSpecificDayForSpecificEmployee(id,date,em);
        if(attendancetrack!=null)
            return false;
        attendancetrack = new Attendancetrack();
        attendancetrack.setArrivalTime(time);
        attendancetrack.setDate(date);
        Employee employee = new Employee();
        employee.setId(id);
        attendancetrack.setEmployee(employee);
        Attendancetrack added = AttendanceDaoImpl.getInstance().add(attendancetrack, em);
        em.close();
        return added!=null;
    }

    @Override
    public boolean markLeave(int id, LocalTime time, LocalDate date) {
        EntityManager em = JpaUtil.createEntityManager();
        Attendancetrack attendancetrack = AttendanceDaoImpl.getInstance().getAttendanceOfSpecificDayForSpecificEmployee(id,date,em);
        if(attendancetrack==null)
            return false;
        attendancetrack.setDepartureTime(time);
        boolean updated = AttendanceDaoImpl.getInstance().update(attendancetrack,em);
        em.close();
        return updated;
    }

    @Override
    public List<AttendanceGet> getAttendanceDataOfEmployee(int employeeID, int month, int year) {
        EntityManager em = JpaUtil.createEntityManager();
        List<Attendancetrack> attendancetrackList = AttendanceDaoImpl.getInstance().getAttendanceOfSpecificDateForSpecificEmployee(employeeID,month,year,em);
        List<AttendanceGet> result = null ;
        if(attendancetrackList==null){
            result = new ArrayList<>();
        }else{
            result = new ArrayList<>();
            for(Attendancetrack attendancetrack:attendancetrackList){
                AttendanceGet get = AttendanceGetMapper.getInstance().convertEntityToModel(attendancetrack);
                result.add(get);
            }
        }
        em.close();
        return result;

    }
}
