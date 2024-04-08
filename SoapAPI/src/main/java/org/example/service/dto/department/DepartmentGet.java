package org.example.service.dto.department;

import lombok.Data;

@Data
public class DepartmentGet {
    private int departmentID;
    private String departmentName;
    private int managerID;

    private String managerName;

    public DepartmentGet(){

    }

}
