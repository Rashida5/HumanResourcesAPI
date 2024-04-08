package org.example.service.services;

import org.example.service.dto.attendance.AttendanceGet;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AttendanceService {
    public boolean markArrive(int id, LocalTime time, LocalDate date);

    public boolean markLeave(int id, LocalTime time, LocalDate date);

    public List<AttendanceGet> getAttendanceDataOfEmployee(int employeeID, int month, int year);


}
