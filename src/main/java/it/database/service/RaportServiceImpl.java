package it.database.service;

import it.database.dao.RaportDAO;
import it.database.entity.Raport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
@Service
@Transactional
public class RaportServiceImpl implements  RaportService {
    @Autowired
    RaportDAO dao;
    @Override
    public List<Raport> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Raport raport){return  dao.save(raport);}
    @Override
    public void update(Raport raport) {
        dao.update(raport);
    }

    @Override
    public void updateAll(List<Raport> list) {
        dao.updateAll(list);
    }

    @Override
    public Raport getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Raport type) {
        dao.delete(type);
    }
}
