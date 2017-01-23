package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Annotation", schema = "mydb")
public class Annotation extends AbstractEntity {
    @Column
    String language;
    @Column
    String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Article_id")
    Article article;

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
