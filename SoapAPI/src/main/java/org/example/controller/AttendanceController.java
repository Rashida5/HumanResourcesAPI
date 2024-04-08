package org.example.controller;


import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.example.controller.util.DateAndTimeValid;
import org.example.service.dto.attendance.AttendanceGet;
import org.example.service.dto.attendance.AttendancePost;
import org.example.service.servicesImp.AttendanceServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebService
public class AttendanceController {
    public AttendanceController(){

    }
    @WebResult(name="markArrive")
    public String markArrive(AttendancePost attendancePost){
        String s="";
        if (!DateAndTimeValid.getInstance().checkValidDate(attendancePost.getDate())) {
            s="The specified date not valid";
        } else if (!DateAndTimeValid.getInstance().checkValidTime(attendancePost.getTime())) {
            s="The specified time not valid";
        } else {
            LocalDate date = LocalDate.parse(attendancePost.getDate());
            LocalTime time = LocalTime.parse(attendancePost.getTime());
            boolean updated = AttendanceServiceImpl.getInstance().markArrive(attendancePost.getEmployeeId(), time, date);
            if (updated) {
                s = "Employee mark arrive successfully";
            }else{
               s = "Failed to mark";
            }
        }
        return s;
    }

@WebResult(name = "markLeave")
    public String markLeave(AttendancePost attendancePost) {
        String s="";
        if (!DateAndTimeValid.getInstance().checkValidDate(attendancePost.getDate())) {
           s= "The specified date not valid";
        } else if (!DateAndTimeValid.getInstance().checkValidTime(attendancePost.getTime())) {
            s= "The specified time not valid";
        } else {
            LocalDate date = LocalDate.parse(attendancePost.getDate());
            LocalTime time = LocalTime.parse(attendancePost.getTime());
            boolean updated = AttendanceServiceImpl.getInstance().markLeave(attendancePost.getEmployeeId(), time, date);
            if (updated) {
                s= "Employee marked leave successfully";
            }else{
                s="Failed to marked as leave";
            }
        }
        return s;
    }

    @WebResult(name="getAttendanceOfEmployee")
    public List<AttendanceGet> getAttendance(@WebParam(name="employeeId") int employeeID, @WebParam(name="month")int month, @WebParam(name="year") int year){
        List<AttendanceGet> list = AttendanceServiceImpl.getInstance().getAttendanceDataOfEmployee(employeeID,month,year);
        return list;
    }


}
