package org.example.service.dto.attendance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Data;


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
