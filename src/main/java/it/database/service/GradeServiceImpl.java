package it.database.service;

import it.database.dao.GradeDAO;
import it.database.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Service
@Transactional
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeDAO dao;
    @Override
    public List<Grade> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Grade grade){return dao.save(grade);}
    @Override
    public void update(Grade grade) {
        dao.update(grade);
    }

    @Override
    public void updateAll(List<Grade> list) {
        dao.updateAll(list);
    }

    @Override
    public Grade getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Grade type) {
        dao.delete(type);
    }
}
