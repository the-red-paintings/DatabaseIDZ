package it.database.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Annotation", schema = "mydb2")
public class Annotation extends AbstractEntity {
    @Column
    String language;
    @Column
    String text;
    @ManyToOne(cascade = CascadeType.ALL)
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
