package org.example.service.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeGet {
    private int employeeId;
    private String firstName;

    private String lastName;

    private String positionName;

    public EmployeeGet(){

    }


}
