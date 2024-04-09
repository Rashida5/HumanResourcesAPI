package org.example.service.dto.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectGet {
    private int projectId;

    private String projectName;

    private String startDate;

    private String endDate;

    private String departmentName;
    public  ProjectGet(){

    }
}
