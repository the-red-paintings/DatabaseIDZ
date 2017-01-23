package it.database.service;

import it.database.dao.ArticleDAO;
import it.database.dao.ArticleDAOImpl;
import it.database.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Service
public interface ArticleService {

    public List<Article> getAll();

    public void update(Article article);

    public void updateAll(List<Article> list);

    public Article getById(int id);

    public void deleteById(int id);

    public void delete(Article type);


}
