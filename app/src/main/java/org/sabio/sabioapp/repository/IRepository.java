package org.sabio.sabioapp.repository;

/**
 * Created by dcortez on 12/14/2017.
 */

public interface IRepository<T> {

    void add(T entity);
    void delete(T entity);
    void update(T entity);
}
