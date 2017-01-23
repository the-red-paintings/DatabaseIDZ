package it.database.entity;

import javax.persistence.*;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Raport", schema = "mydb")
public class Raport extends AbstractEntity {
    @Column
    String conclussion;
    @Column
    String remark;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReviewer", nullable = false)
    Reviewer reviewer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Article_id", nullable = false)
    Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getConclussion() {
        return conclussion;
    }

    public void setConclussion(String conclussion) {
        this.conclussion = conclussion;
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
