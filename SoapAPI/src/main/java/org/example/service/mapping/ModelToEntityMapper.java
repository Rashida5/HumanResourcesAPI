package org.example.service.mapping;

public interface ModelToEntityMapper<T,U> {
    public T convertModelToEntity(U e);
}
