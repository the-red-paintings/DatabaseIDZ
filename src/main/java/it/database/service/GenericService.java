package it.database.service;

import it.database.dao.GenericDAO;
import it.database.dao.GenericDAOImpl;
import it.database.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
public abstract class GenericService<Dao extends GenericDAO, E extends AbstractEntity> {
    @Autowired
    protected GenericDAO dao;

    public GenericService(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        dao = (GenericDAOImpl<E>) pt.getActualTypeArguments()[0];
    }

    public List<E> getAll() {
        return dao.getAll();
    }

    public void update(E type){
        dao.update(type);
    };

    public void updateAll(List<E> list) {
        dao.updateAll(list);
    }

//    public E getById(int id) {
//        (E)return dao.getById(id);
//    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public void delete(E type) {
        dao.delete(type);
    }
}
