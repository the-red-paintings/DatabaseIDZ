package it.database.service;

import it.database.entity.Keywords;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
public interface KeywordsService {
    public List<Keywords> getAll();

    public void update(Keywords keywords);

    public void updateAll(List<Keywords> list);

    public Keywords getById(int id);

    public void deleteById(int id);

    public void delete(Keywords type);

    int save(Keywords keywords);
}
