package it.database.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by the-red-paintings on 22.01.2017.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
