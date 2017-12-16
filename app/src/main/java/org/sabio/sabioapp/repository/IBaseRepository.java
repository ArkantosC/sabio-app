package org.sabio.sabioapp.repository;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public interface IBaseRepository<T> {
    Long insert(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    List<T> getById(Long id);
}
