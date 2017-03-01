package it.database.dao;

import it.database.entity.AbstractEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by the-red-paintings on 03.01.2017.
 */
public abstract class GenericDAOImpl<T extends AbstractEntity> implements GenericDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
    @Override
    public int save(T type){
        return (int) sessionFactory.getCurrentSession().save(type);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) sessionFactory.getCurrentSession().createQuery("from "+type.getName()).list();
    }

    @Override
    public void update(T type) {
        sessionFactory.getCurrentSession().update(type);
        sessionFactory.getCurrentSession().flush();
    }
    @Override
    public T getById(int id){
        return (T) sessionFactory.getCurrentSession().createQuery("from "+type.getName()+" as t where t.id="+id).getSingleResult();
    }
    @Override
    public void updateAll(List<T> list) {
        list.forEach(item -> update(item));
    }

    @Override
    public void delete(T type) {
        sessionFactory.getCurrentSession().delete(type);
    }

    @Override
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().createQuery("delete "+type.getName()+" t where t.id="+id).executeUpdate();
    }



}
