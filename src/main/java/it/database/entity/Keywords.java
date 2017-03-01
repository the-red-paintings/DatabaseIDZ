package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Keywords", schema = "mydb2")
public class Keywords extends AbstractEntity {
    @Column
    String language;
    @Column
    String word;
    @ManyToOne(  cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "Article_id", nullable = true)
    Article article;

    transient Integer articleId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
