package org.example.service.dto.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePost {
    private int employeeId;
    private String firstName;
    private String lastName;

    private int departmentId;
    private int positionId;



    private String city;

    private String street;

    private String apartmentNumber;

    private String mobilePhone;

    private String email;

    public EmployeePost(){

    }

    public EmployeePost(String firstName, String lastName, int departmentId, int positionId, String city, String street, String apartmentNumber, String mobilePhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.city = city;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }
}
