package it.database.service;

import it.database.dao.AutorDAO;
import it.database.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Transactional
@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    AutorDAO dao;
    @Override
    public List<Autor> getAll() {
        return dao.getAll();
    }
    @Override
    public int save(Autor autor){return  dao.save(autor);}
    @Override
    public void update(Autor autor) {
        dao.update(autor);
    }

    @Override
    public void updateAll(List<Autor> list) {
        dao.updateAll(list);
    }

    @Override
    public Autor getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Autor type) {
        dao.delete(type);
    }
}
