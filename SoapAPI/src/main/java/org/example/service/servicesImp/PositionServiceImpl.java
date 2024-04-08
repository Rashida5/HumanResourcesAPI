package org.example.service.servicesImp;

import jakarta.persistence.EntityManager;
import org.example.persistence.daosImpl.PositionsDaoImp;
import org.example.persistence.entities.Position;
import org.example.persistence.util.JpaUtil;
import org.example.service.dto.position.PositionGet;
import org.example.service.mapping.position.PositionGetMapper;
import org.example.service.services.PositionsService;

import java.util.Optional;

public class PositionServiceImpl implements PositionsService {

    private static PositionServiceImpl instance;
    @Override
    public boolean addPosition(String positionName, int salary) {
        EntityManager em = JpaUtil.createEntityManager();
        Position position = new Position();
        position.setPositionName(positionName);
        position.setSalary(salary);
        Position positionResult = PositionsDaoImp.getInstance().add(position, em);
        em.close();
        return positionResult != null;
    }

    @Override
    public boolean deletePositionById(int id) {
        return false;
    }

    @Override
    public PositionGet getPositionByName(String positionByName) {
        EntityManager em = JpaUtil.createEntityManager();
        Optional<Position> position = PositionsDaoImp.getInstance().getPositionByName(positionByName,em);
        em.close();
        if(position.isEmpty()){
            return new PositionGet();
        }else{
            PositionGet positionGet = PositionGetMapper.getInstance().convertEntityToModel(position.get());
            return positionGet;
        }
    }

    @Override
    public PositionGet getPositionById(int positionById) {
        EntityManager em = JpaUtil.createEntityManager();
        Position position = PositionsDaoImp.getInstance().getById(positionById,em);
        System.out.println(position);
        if(position==null){
            return new PositionGet();
        }else{
            return PositionGetMapper.getInstance().convertEntityToModel(position);
        }

    }
    private PositionServiceImpl(){

    }
    public static PositionServiceImpl getInstance(){
        if(instance==null){
            instance = new PositionServiceImpl();
        }
        return instance;
    }
}
