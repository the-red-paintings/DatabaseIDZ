package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Grade", schema = "mydb")
public class Grade extends AbstractEntity {
    @Column
    int mark;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReviewer", nullable = false)
    Reviewer reviewer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Article_id", nullable = false, updatable = false)
    Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
}
