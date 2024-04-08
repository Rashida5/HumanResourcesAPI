package org.example.service.dto.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.position.PositionGet;
import org.example.service.servicesImp.AttendanceServiceImpl;
import org.example.service.servicesImp.EmployeeServiceImpl;
import org.example.service.servicesImp.PositionServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendancePost {
    private int employeeId;
    private String time;

    private String date;

    public AttendancePost(){

    }
}
