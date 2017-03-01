package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Raport", schema = "mydb2")
public class Raport extends AbstractEntity {
    @Column
    String conclusion;
    @Column
    String remark;
    @ManyToOne(  cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "idReviewer", nullable = false, referencedColumnName = "id")
    Reviewer reviewer;
    @ManyToOne(  cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "Article_id", nullable = false)
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

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclussion) {
        this.conclusion = conclussion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
}
