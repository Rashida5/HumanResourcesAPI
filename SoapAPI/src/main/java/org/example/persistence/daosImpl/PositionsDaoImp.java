package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.PositionsDao;
import org.example.persistence.entities.Position;

import java.util.Optional;

public class PositionsDaoImp implements PositionsDao {

    private static PositionsDaoImp instance;


    private PositionsDaoImp(){

    }
    public static PositionsDaoImp getInstance(){
        if(instance ==null){
            instance = new PositionsDaoImp();
        }
        return instance;
    }

    @Override
    public Position add(Position entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println(entity.getId());
        return entity;
    }

    public Optional<Position> getPositionByName(String name, EntityManager em){
        String jpql = "SELECT e FROM Position e WHERE e.positionName = :name";

        TypedQuery<Position> query = em.createQuery(jpql, Position.class);
        query.setParameter("name", name);
        Optional<Position> position = Optional.ofNullable(query.getSingleResult());
        return  position;
    }

    @Override
    public Position getById(int id, EntityManager em) {
        Position position = em.find(Position.class, id);

        return position;
    }

    @Override
    public boolean update(Position entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(Position entity, EntityManager em) {
        return false;
    }
}
