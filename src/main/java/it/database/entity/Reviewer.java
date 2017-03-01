package it.database.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Reviewer", schema = "mydb2")
public class Reviewer extends AbstractEntity {
    @Column
    String fio;
    @OneToMany( cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idReviewer")
    List<Grade> gradeList;
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idReviewer")
    List<Raport> raportList;
    @ManyToMany(cascade = CascadeType.REFRESH)
        @JoinTable(name="Raport", joinColumns=@JoinColumn(name="idReviewer"), inverseJoinColumns=@JoinColumn(name="Article_id"))
    List<Article> articles;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Raport> getRaportList() {
        return raportList;
    }

    public void setRaportList(List<Raport> raportList) {
        this.raportList = raportList;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
