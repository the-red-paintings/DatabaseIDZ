package it.database.service;

import it.database.entity.Annotation;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
public interface AnnotationService {
    public List<Annotation> getAll();

    public void update(Annotation Annotation);

    public void updateAll(List<Annotation> list);

    public Annotation getById(int id);

    public void deleteById(int id);

    public void delete(Annotation type);

    public int save(Annotation annotation);
}
