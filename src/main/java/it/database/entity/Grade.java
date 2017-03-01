package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Grade", schema = "mydb2")
public class Grade extends AbstractEntity {
    @Column
    int mark;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idReviewer")
    Reviewer reviewer;
    @ManyToOne()
    @JoinColumn(name = "Article_id", nullable = false, updatable = true, referencedColumnName = "id")
    Article article;

    transient Integer articleId;

    transient Integer reviewerId;

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

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
