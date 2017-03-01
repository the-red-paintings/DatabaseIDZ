package it.database.service;

import it.database.entity.Raport;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
public interface RaportService {
    public List<Raport> getAll();

    int save(Raport raport);

    public void update(Raport raport);

    public void updateAll(List<Raport> list);

    public Raport getById(int id);

    public void deleteById(int id);

    public void delete(Raport type);
}
