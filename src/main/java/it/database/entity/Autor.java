package it.database.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@Entity
@Table(name = "Autor", schema = "mydb")
public class Autor extends AbstractEntity {
    @Column(updatable = true)
    String fio;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="Autor_has_Article", joinColumns=@JoinColumn(name="Autor_id"), inverseJoinColumns=@JoinColumn(name="Article_id"))
    List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
