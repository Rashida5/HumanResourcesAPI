package org.example.service.dto.department;

import lombok.Data;

@Data
public class DepartmentPost {
    private int departmentID;
    private String departmentName;

    private int mangerId;
    public DepartmentPost(){

    }

    public DepartmentPost(int departmentID, String departmentName, int mangerId) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.mangerId = mangerId;
    }

    public DepartmentPost(String departmentName, int mangerId) {
        this.departmentName = departmentName;
        this.mangerId = mangerId;
    }
}
