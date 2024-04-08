package org.example.service.mapping.attendance;

import org.example.persistence.entities.Attendancetrack;
import org.example.service.dto.attendance.AttendanceGet;
import org.example.service.mapping.EntityMapperToModel;

public class AttendanceGetMapper implements EntityMapperToModel<AttendanceGet, Attendancetrack> {

    public static AttendanceGetMapper instance;
    private AttendanceGetMapper(){

    }
    public static AttendanceGetMapper getInstance(){
        if(instance==null)
            instance = new AttendanceGetMapper();
        return instance;
    }
    @Override
    public AttendanceGet convertEntityToModel(Attendancetrack e) {
        AttendanceGet attendanceGet = new AttendanceGet();
        attendanceGet.setArrival(e.getArrivalTime());
        attendanceGet.setLeave(e.getDepartureTime());
        attendanceGet.setDate(e.getDate());
        return attendanceGet;
    }
}
