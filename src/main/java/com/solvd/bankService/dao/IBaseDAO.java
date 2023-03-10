package com.solvd.bankService.dao;

public interface IBaseDAO<T> {

    T getEntityById(long id);

    void updateEntity(T entity);

    T createEntity(T entity);

    void removeEntity(long id);

    void createEntityMyBatis(T entity);

}
