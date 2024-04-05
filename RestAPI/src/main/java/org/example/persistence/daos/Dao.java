package org.example.persistence.daos;

import jakarta.persistence.EntityManager;

public interface Dao <T>{
    T add(T entity, EntityManager em);

   T getById(int id, EntityManager em);

    boolean update(T entity , EntityManager em);

    boolean delete(T entity, EntityManager em);
}
