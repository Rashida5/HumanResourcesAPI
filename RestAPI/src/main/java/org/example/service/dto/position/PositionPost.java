package org.example.service.dto.position;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionPost {
    private String name;
    private int salary;
    public PositionPost(){

    }
}
