package org.example.controller;

import jakarta.ws.rs.core.Response;
import org.example.service.dto.position.PositionPost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionsControllerTest {

    @Test
    void getPositionByID() {
        PositionsController positionsController = new PositionsController();
        Response response = positionsController.getPositionByID(1);
        assertEquals(200, response.getStatus());
    }

    @Test
    void addPosition() {
        PositionsController positionsController = new PositionsController();
        PositionPost positionPost = new PositionPost("OS",10000);
        Response response = positionsController.addPosition(positionPost);
        assertEquals(200, response.getStatus());
    }

    @Test
    void getPositionByName() {
        PositionsController positionsController = new PositionsController();
        Response response = positionsController.getPositionByName("Software Engineer");
        assertEquals(200, response.getStatus());
    }
}