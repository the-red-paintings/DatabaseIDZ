package it.database.service;

import it.database.dao.ArticleDAO;
import it.database.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Service("service")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDAO dao;
    @Override
    public List<Article> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(Article article) {
        dao.update(article);
    }

    @Override
    public void updateAll(List<Article> list) {
        dao.updateAll(list);
    }

    @Override
    public Article getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(Article type) {
        dao.delete(type);
    }
}
