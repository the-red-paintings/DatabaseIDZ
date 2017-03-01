package it.database.service;

import it.database.entity.Autor;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
public interface AutorService {
    public List<Autor> getAll();

    int save(Autor autor);

    public void update(Autor autor);

    public void updateAll(List<Autor> list);

    public Autor getById(int id);

    public void deleteById(int id);

    public void delete(Autor type);

}
