package org.example.controller;

import jakarta.ws.rs.core.Response;
import org.example.service.dto.department.DepartmentPost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentControllerTest {

    @Test
    void addDepartment() {
        DepartmentController departmentController = new DepartmentController();
        DepartmentPost departmentPost = new DepartmentPost("Database",5);
        Response response = departmentController.addDepartment(departmentPost);
        assertEquals(200, response.getStatus());
    }

    @Test
    void getDepartment() {
        DepartmentController departmentController = new DepartmentController();
        Response response = departmentController.getDepartment(1);
        assertEquals(200, response.getStatus());

    }

    @Test
    void updateDepartment() {
        DepartmentController departmentController = new DepartmentController();
        DepartmentPost departmentPost = new DepartmentPost();
        departmentPost.setDepartmentID(3);
        departmentPost.setDepartmentName("REST");
        Response response = departmentController.updateDepartment(departmentPost);
        assertEquals(200, response.getStatus());
    }
}