package org.example.service.dto.employee;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyEmployeeTracking {

    private String name;
    private double netSalary;
    private double salary;
    private int numberOfDaysPresent;
    private int numberOfWorkingHours;
    private int numberOfWorkingAbsent;
    private int bonusHours;

    public MonthlyEmployeeTracking(){

    }



}
