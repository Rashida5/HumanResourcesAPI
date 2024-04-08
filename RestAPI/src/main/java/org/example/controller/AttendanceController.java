package org.example.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.controller.util.DateAndTimeValid;
import org.example.service.dto.attendance.AttendanceGet;
import org.example.service.dto.attendance.AttendancePost;
import org.example.service.servicesImp.AttendanceServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Path("attendance")
public class AttendanceController {
    public AttendanceController(){

    }
    @Path("attendEmployee")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response markArrive(AttendancePost attendancePost){
        Response response;
        if (!DateAndTimeValid.getInstance().checkValidDate(attendancePost.getDate())) {
            response = Response.status(404, "The specified date not valid").build();
        } else if (!DateAndTimeValid.getInstance().checkValidTime(attendancePost.getTime())) {
            response=Response.status(404, "The specified time not valid").build();
        } else {
            LocalDate date = LocalDate.parse(attendancePost.getDate());
            LocalTime time = LocalTime.parse(attendancePost.getTime());
            boolean updated = AttendanceServiceImpl.getInstance().markArrive(attendancePost.getEmployeeId(), time, date);
            if (updated) {
                response = Response.accepted().build();
            }else{
                response = Response.notModified().build();
            }
        }
        return response;
    }

    @Path("leaveEmployee")
    @PUT
    public Response markLeave(AttendancePost attendancePost) {
        Response response;
        if (!DateAndTimeValid.getInstance().checkValidDate(attendancePost.getDate())) {
            response = Response.status(404, "The specified date not valid").build();
        } else if (!DateAndTimeValid.getInstance().checkValidTime(attendancePost.getTime())) {
            response=Response.status(404, "The specified time not valid").build();
        } else {
            LocalDate date = LocalDate.parse(attendancePost.getDate());
            LocalTime time = LocalTime.parse(attendancePost.getTime());
            boolean updated = AttendanceServiceImpl.getInstance().markLeave(attendancePost.getEmployeeId(), time, date);
            if (updated) {
                response = Response.accepted().build();
            }else{
                response = Response.notModified().build();
            }
        }
        return response;
    }

    @Path("getAttendanceOfEmployee")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAttendance(@QueryParam("employeeId") int employeeID, @QueryParam("month")int month, @QueryParam("year") int year, @Context UriInfo uriInfo){
        List<AttendanceGet> list = AttendanceServiceImpl.getInstance().getAttendanceDataOfEmployee(employeeID,month,year);
        return Response.ok(list).build();
    }


}
