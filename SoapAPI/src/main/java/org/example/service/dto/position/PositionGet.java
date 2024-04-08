package org.example.service.dto.position;

import lombok.Data;

@Data
public class PositionGet {
    private int positionId;
    private String positionName;

    private int salary;
}
