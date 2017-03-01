package it.database.dao;


import it.database.entity.AbstractEntity;

import java.util.List;

/**
 * Created by the-red-paintings on 03.01.2017.
 */
public interface GenericDAO<T extends AbstractEntity> {
    public int save(T type);

    public List<T> getAll();

    public void update(T type);

    public void updateAll(List<T> list);

    public T getById(int id);

    public void deleteById(int id);

    public void delete(T type);
}
