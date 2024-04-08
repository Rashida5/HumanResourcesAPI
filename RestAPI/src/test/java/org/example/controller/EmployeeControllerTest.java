package org.example.controller;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.dto.employee.EmployeePost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeControllerTest {

    @Test
    public void getEmployee() {
        EmployeeController employeeController = new EmployeeController();
        int id= 1;
        Response response = employeeController.getEmployee(id);
        assertEquals(200,response.getStatus());

    }
    @Test
    void addEmployee() {
        EmployeeController employeeController = new EmployeeController();
        EmployeePost employeePost = new EmployeePost("Maram","Saber",1,1,"Menouf","TallatHarab","10","01111222444","Shrouk@gmail.com");
        Response response = employeeController.addEmployee(employeePost);
        assertEquals(200,response.getStatus());
    }

    @Test
    void updateEmployee() {
        EmployeeController employeeController = new EmployeeController();
        EmployeePost employeePost = new EmployeePost();
        employeePost.setEmployeeId(5);
        employeePost.setCity("Cairo");
        Response response = employeeController.updateEmployee(employeePost);
        assertEquals(200, response.getStatus());
    }

    @Test
    void deleteEmployee() {
        EmployeeController employeeController = new EmployeeController();
        Response response = employeeController.deleteEmployee(5);
        assertEquals(200, response.getStatus());
    }
}