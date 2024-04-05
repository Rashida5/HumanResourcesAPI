package org.example.service.mapping;

public interface EntityMapperToModel<T,U>{

     public T convertEntityToModel(U e);

}
