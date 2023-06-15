package services;

import java.util.List;

public interface GenericService<T> {
    T getById(int id);
    List<T> getAll();
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
