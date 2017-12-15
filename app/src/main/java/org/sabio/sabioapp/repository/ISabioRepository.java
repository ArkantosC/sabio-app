package org.sabio.sabioapp.repository;

import java.util.List;

/**
 * Created by diegocortes on 12/14/17.
 */

public interface ISabioRepository<T> {
    Long insert(T entity);
    void update(T entity);
    void delete(T entity);
}
