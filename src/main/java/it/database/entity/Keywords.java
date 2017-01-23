package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Keywords", schema = "mydb")
public class Keywords extends AbstractEntity {
    @Column
    String language;
    @Column
    String word;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Article_id", nullable = false)
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
