package it.database.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Article", schema = "mydb")
public class Article extends AbstractEntity {
    @Column
    String language;
    @Column
    String name;
    @Column
    String text;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    List<Keywords> keywords;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "articles",cascade = CascadeType.ALL)
    List<Autor> autors;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL  , mappedBy = "article" )
    List<Grade> grades;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    List<Annotation> annotations;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    List<Raport> raports;
    @ManyToMany(mappedBy = "articles")
    List<Reviewer> reviewers;

    @Override
    public String toString() {
        return "Article{" +

                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +

                '}';
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Keywords> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keywords> keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Raport> getRaports() {
        return raports;
    }

    public void setRaports(List<Raport> raports) {
        this.raports = raports;
    }

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
