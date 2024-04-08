package org.example.service.dto.position;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionPost {
    private String name;
    private int salary;

    public PositionPost(){

    }
}
