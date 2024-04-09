package org.example.service.dto.employee;


import lombok.Data;

@Data
public class EmployeeGetDetail {
    private int employeeId;

    private String firstName;

    private String lastName;

    private String departmentName;

    private int netSalary;

    private String positionName;

    private String address;

    private String hire_date;
    private String end_date;

    private String phoneNumber;
    private String email;

}
