package org.example.service.dto.project;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectPost {
    private int projectID;
    private String projectName;

    private String startDate;

    private String endDate;
    private int departmentId;
    public ProjectPost(){

    }
}
