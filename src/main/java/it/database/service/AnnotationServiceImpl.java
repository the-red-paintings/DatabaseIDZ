package it.database.service;

import it.database.dao.AnnotationDAO;
import it.database.entity.Annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Service
@Transactional
public class AnnotationServiceImpl implements AnnotationService {
    @Autowired
    AnnotationDAO dao;
    @Override
    public List<Annotation> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Annotation annotation){
        return dao.save(annotation);
    }

    @Override
    public void update(Annotation annotation) {
        dao.update(annotation);
    }

    @Override
    public void updateAll(List<Annotation> list) {
        dao.updateAll(list);
    }

    @Override
    public Annotation getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Annotation type) {
        dao.delete(type);
    }
}
