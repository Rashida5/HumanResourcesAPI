package org.example.service.mapping.position;

import org.example.persistence.entities.Position;
import org.example.service.dto.position.PositionGet;
import org.example.service.mapping.EntityMapperToModel;

public class PositionGetMapper implements EntityMapperToModel<PositionGet, Position> {

    private static PositionGetMapper instance;
    @Override
    public PositionGet convertEntityToModel(Position e) {

        PositionGet positionGet = new PositionGet();
        positionGet.setPositionId(e.getId());
        positionGet.setPositionName(e.getPositionName());
        positionGet.setSalary(e.getSalary());
        return positionGet;
    }
    private PositionGetMapper(){

    }
    public static PositionGetMapper getInstance(){
        if(instance==null){
            instance = new PositionGetMapper();
        }
        return instance;
    }


}
