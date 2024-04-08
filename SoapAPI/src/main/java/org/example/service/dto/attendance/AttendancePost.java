package org.example.service.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AttendancePost {
    private int employeeId;
    private String time;

    private String date;

    public AttendancePost(){

    }
}
