package it.database.service;

import it.database.entity.Grade;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
public interface GradeService {
    public List<Grade> getAll();

    int save(Grade grade);

    public void update(Grade grade);

    public void updateAll(List<Grade> list);

    public Grade getById(int id);

    public void deleteById(int id);

    public void delete(Grade type);
}
