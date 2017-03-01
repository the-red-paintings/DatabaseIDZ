package it.database.entity;

import com.sun.scenario.effect.Merge;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Article", schema = "mydb2")
public class Article extends AbstractEntity {
    @Column
    String language;
    @Column
    String name;
    @Column
    String text;
    @OneToMany
    @JoinColumn(name = "Article_id")
    List<Keywords> keywords;
    @ManyToMany()
    @JoinTable(name="Autor_has_Article", joinColumns=@JoinColumn(name="Article_id",updatable = true), inverseJoinColumns=@JoinColumn(name="Autor_id",updatable = true))
    List<Autor> autors;
    @OneToMany
    @JoinColumn(name = "Article_id")
    List<Grade> grades;
    @OneToMany
    @JoinColumn(name = "Article_id")
    List<Annotation> annotations;
    @OneToMany
    @JoinColumn(name = "Article_id")
    List<Raport> raports;
    @ManyToMany()
    @JoinTable(name="Raport", joinColumns=@JoinColumn(name="Article_id"), inverseJoinColumns=@JoinColumn(name="idReviewer"))
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
