package it.database.service;

import it.database.dao.ReviewerDAO;
import it.database.entity.Reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Service
@Transactional
public class ReviewerServiceImpl implements  ReviewerService {
    @Autowired
    ReviewerDAO dao;
    @Override
    public List<Reviewer> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Reviewer reviewer){return  dao.save(reviewer); }
    @Override
    public void update(Reviewer reviewer) {
        dao.update(reviewer);
    }

    @Override
    public void updateAll(List<Reviewer> list) {
        dao.updateAll(list);
    }

    @Override
    public Reviewer getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Reviewer type) {
        dao.delete(type);
    }
}
