package org.example.service.services;

import org.example.service.dto.position.PositionGet;

public interface PositionsService {


    public boolean addPosition(String positionName, int Salary);
    public boolean deletePositionById(int id);

    public PositionGet getPositionByName(String positionByName);

    public PositionGet getPositionById(int positionById);

}
