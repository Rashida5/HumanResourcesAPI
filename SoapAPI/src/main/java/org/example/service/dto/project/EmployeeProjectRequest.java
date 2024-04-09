package org.example.service.dto.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeProjectRequest {
    private int employeeId;
    private int projectId;
    public EmployeeProjectRequest(){

    }
}
