package org.example.controller;
import jakarta.ws.rs.core.Response;
import org.example.service.dto.attendance.AttendancePost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AttendanceControllerTest {

    @Test
    void markArriveTest() {
        AttendanceController attendanceController = new AttendanceController();
        AttendancePost attendancePost = new AttendancePost();
        attendancePost.setEmployeeId(3);
        attendancePost.setTime("14:10:19");
        attendancePost.setDate("2024-04-11");
        Response response = attendanceController.markArrive(attendancePost);
        assertEquals(304, response.getStatus());

    }

    @Test
    void markLeave() {
        AttendanceController attendanceController = new AttendanceController();
        AttendancePost attendancePost = new AttendancePost();
        attendancePost.setEmployeeId(4);
        attendancePost.setTime("09:10:18");
        attendancePost.setDate("2024-04-08");
        Response response = attendanceController.markLeave(attendancePost);
        assertEquals(202, response.getStatus());
    }

}