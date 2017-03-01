package it.database.service;

import it.database.dao.KeywordsDAO;
import it.database.entity.Keywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Service
@Transactional
public class KeywordsServiceImpl implements KeywordsService {
    @Autowired
    KeywordsDAO dao;
    @Override
    public List<Keywords> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Keywords keywords){
        return dao.save(keywords);
    }

    @Override
    public void update(Keywords keywords) {
        dao.update(keywords);
    }

    @Override
    public void updateAll(List<Keywords> list) {
        dao.updateAll(list);
    }

    @Override
    public Keywords getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Keywords type) {
        dao.delete(type);
    }
}
