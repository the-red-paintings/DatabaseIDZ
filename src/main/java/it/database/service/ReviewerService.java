package it.database.service;

import it.database.entity.Reviewer;

import java.util.List;

/**
 * Created by the-red-paintings on 29.01.2017.
 */
public interface ReviewerService {
    public List<Reviewer> getAll();

    int save(Reviewer reviewer);

    public void update(Reviewer Reviewer);

    public void updateAll(List<Reviewer> list);

    public Reviewer getById(int id);

    public void deleteById(int id);

    public void delete(Reviewer type);
}
