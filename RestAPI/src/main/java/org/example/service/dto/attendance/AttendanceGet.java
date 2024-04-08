package org.example.service.dto.attendance;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AttendanceGet {
    LocalDate date;

    LocalTime arrival;

    LocalTime leave;

}
